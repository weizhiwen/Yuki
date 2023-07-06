package com.yuki.common.core.service;

import com.yuki.common.core.dao.BaseRepo;
import com.yuki.common.core.domain.CreateParam;
import com.yuki.common.core.domain.UpdateParam;
import com.yuki.common.core.domain.entity.BaseEntity;
import com.yuki.common.core.reader.BaseReader;
import com.yuki.common.core.validate.CreateValidate;
import com.yuki.common.core.validate.UpdateValidate;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.function.Supplier;


@SuppressWarnings("unchecked")
@Validated
public abstract class BaseBusinessService<C extends CreateParam, U extends UpdateParam, T extends BaseEntity> {

    @Getter
    private Class<C> createClass;
    @Getter
    private Class<U> updateClass;
    @Getter
    private Class<T> entityClass;

    @PostConstruct
    protected void init() {
        createClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        updateClass = (Class<U>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    }


    protected abstract BaseRepo getRepo();

    public List<T> list(Specification query) {
        return getRepo().findAll(query);
    }

    public Page<T> page(Specification query, Pageable pageable) {
        return getRepo().findAll(query, pageable);
    }

    protected void validateOnCreate(C param) {
    }

    protected abstract T onCreate(C param);

    @Transactional
    @Validated(value = {CreateValidate.class})
    public T create(@Valid C param) {
        validateOnCreate(param);
        T t = onCreate(param);
        getRepo().save(t);
        return t;
    }

    protected void validateOnUpdate(U param) {

    }

    protected abstract T onUpdate(U param, T entity);

    @Transactional
    @Validated(value = {UpdateValidate.class})
    public T update(@Valid U param) {
        validateOnUpdate(param);
        T t = (T) getRepo().findOrThrowErrorById(param.getId());
        onUpdate(param, t);
        getRepo().save(t);
        return t;
    }

    protected void validateOnDelete(T t) {
    }

    @Transactional
    public void delete(Long id) {
        T t = (T) getRepo().findOrThrowErrorById(id);
        validateOnDelete(t);
        getRepo().delete(t);
    }

    public T get(Long id) {
        return (T) getRepo().findOrThrowErrorById(id);
    }

    public void executeWithReader(Supplier<T> supplier, BaseReader reader) {
        T t = supplier.get();
        reader.read(t);
    }
}
