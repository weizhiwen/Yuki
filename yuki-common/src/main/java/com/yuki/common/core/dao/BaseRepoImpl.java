package com.yuki.common.core.dao;

import com.yuki.common.core.exception.BaseException;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;
public class BaseRepoImpl<T, I extends Serializable> extends SimpleJpaRepository<T, I> implements BaseRepo<T, I> {

    public BaseRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public BaseRepoImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public T findOrThrowErrorById(I id) {
        Optional<T> one = findById(id);
        if (one.isPresent()) {
            return one.get();
        }
        throw new BaseException("id.not.found", id, getDomainClass().getSimpleName());
    }
}
