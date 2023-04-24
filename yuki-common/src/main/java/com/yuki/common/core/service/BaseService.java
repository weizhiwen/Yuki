package com.yuki.common.core.service;

import com.yuki.common.core.domain.CreateParam;
import com.yuki.common.core.domain.UpdateParam;
import com.yuki.common.core.domain.entity.BaseEntity;
import com.yuki.common.core.dao.BaseRepo;
import com.yuki.common.core.reader.BaseReader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.function.Supplier;


@SuppressWarnings("unchecked")
public abstract class BaseService<Create extends CreateParam, Update extends UpdateParam, T extends BaseEntity> {

    protected Class<Create> createClass;
    protected Class<Update> updateClass;
    protected Class<T> entityClass;

    @PostConstruct
    protected void init() {
        createClass = (Class<Create>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        updateClass = (Class<Update>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    }


    protected abstract BaseRepo getRepo();


    public Page<T> page(Specification query, Pageable pageable) {
        return getRepo().findAll(query, pageable);
    }

    protected void validateOnCreate(Create param) {
    }

    protected abstract T onCreate(Create param);

    @Transactional
    public T create(Create param) {
        validateOnCreate(param);
        T t = onCreate(param);
        getRepo().save(t);
        return t;
    }

    protected void validateOnUpdate(Update param) {

    }

    protected abstract T onUpdate(Update param, T entity);

    @Transactional
    public T update(Update param) {
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
