package com.yuki.common.core.dao;

import com.yuki.common.core.exception.BaseException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

@Repository
public abstract class BaseRepoImpl<T, ID extends Serializable> implements BaseRepo<T, ID> {
    protected Class<T> entityClass;

    @PostConstruct
    protected void init() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findOrThrowErrorById(ID id) {
        Optional<T> one = findById(id);
        if (one.isPresent()) {
            return one.get();
        }
        throw new BaseException("id.not.found", id, entityClass.getSimpleName());
    }
}
