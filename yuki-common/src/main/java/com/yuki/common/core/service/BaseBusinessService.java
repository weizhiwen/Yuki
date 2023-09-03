package com.yuki.common.core.service;

import com.yuki.common.core.dao.BaseRepo;
import com.yuki.common.core.domain.CreateParam;
import com.yuki.common.core.domain.UpdateParam;
import com.yuki.common.core.domain.entity.BaseEntity;
import com.yuki.common.core.domain.entity.CanDisableEntity;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.mapper.BusinessMapper;
import com.yuki.common.core.reader.BaseReader;
import com.yuki.common.core.validate.CreateValidate;
import com.yuki.common.core.validate.UpdateValidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.function.Supplier;


@Validated
public abstract class BaseBusinessService<C extends CreateParam, U extends UpdateParam, T extends BaseEntity, V> {
    private Class<T> entityClass;

    protected abstract BaseRepo<T, Long> getRepo();

    protected abstract BusinessMapper<T, C, U, V> getMapper();

    @PostConstruct
    protected void init() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    }

    @Transactional(readOnly = true)
    public List<T> list(Specification<T> query) {
        return getRepo().findAll(query);
    }

    @Transactional(readOnly = true)
    public Page<T> page(Specification<T> query, Pageable pageable) {
        return getRepo().findAll(query, pageable);
    }

    protected void validateCreateParam(C param) {

    }

    protected T onCreate(C param) {
        return getMapper().paramToEntity(param);
    }

    @Transactional
    @Validated(value = {CreateValidate.class})
    public T create(@Valid C param) {
        validateCreateParam(param);
        T t = onCreate(param);
        getRepo().save(t);
        return t;
    }

    protected void validateUpdateParam(U param) {

    }

    protected void validateOnUpdate(U param, T entity) {

    }

    protected void onUpdate(U param, T entity) {
        getMapper().paramToEntity(param, entity);
    }

    @Transactional
    @Validated(value = {UpdateValidate.class})
    public T update(@Valid U param) {
        validateUpdateParam(param);
        T t = getRepo().findOrThrowErrorById(param.getId());
        validateOnUpdate(param, t);
        onUpdate(param, t);
        getRepo().save(t);
        return t;
    }

    protected void validateOnDelete(T entity) {
    }

    @Transactional
    public void delete(Long id) {
        T t = getRepo().findOrThrowErrorById(id);
        validateOnDelete(t);
        getRepo().delete(t);
    }

    @Transactional
    public T get(Long id) {
        return getRepo().findOrThrowErrorById(id);
    }

    @Transactional(readOnly = true)
    public void executeWithReader(Supplier<T> supplier, BaseReader<T, ?> reader) {
        T t = supplier.get();
        reader.read(t);
    }

    @Transactional(readOnly = true)
    public void executeListWithReader(Supplier<List<T>> supplier, BaseReader<T, ?> reader) {
        List<T> list = supplier.get();
        reader.read(list);
    }

    @Transactional
    public void disable(Long id, Boolean disabled) {
        T t = getRepo().findOrThrowErrorById(id);
        if (t instanceof CanDisableEntity) {
            ((CanDisableEntity) t).setDisabled(disabled);
        } else {
            throw new BaseException("entity.not.support.disable.or.enable", entityClass.getSimpleName());
        }
        getRepo().save(t);
    }
}
