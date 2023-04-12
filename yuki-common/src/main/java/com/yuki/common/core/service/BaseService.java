package com.yuki.common.core.service;

import com.yuki.common.core.domain.CreateParam;
import com.yuki.common.core.domain.UpdateParam;
import com.yuki.common.core.domain.entity.BaseEntity;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.mapper.BaseMapper;
import com.yuki.common.core.reader.BaseReader;
import com.yuki.common.core.repo.BaseRepo;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;


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


    public void executeWithReader(BaseReader reader, Executable<T> executable) {
        T execute = executable.execute();
        reader.read(execute);
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
        T t = findByIdOrElseThrowException(param.getId());
        onUpdate(param, t);
        getRepo().save(t);
        return t;
    }

    protected void validateOnDelete(T t) {
    }

    @Transactional
    public void delete(Long id) {
        T t = findByIdOrElseThrowException(id);
        validateOnDelete(t);
        getRepo().delete(t);
    }

    public T findByIdOrElseThrowException(Long id) {
        Optional<T> one = getRepo().findById(id);
        if (one.isPresent()) {
            return one.get();
        }
        throw new BaseException("id.not.found", id, entityClass.getSimpleName());
    }
}
