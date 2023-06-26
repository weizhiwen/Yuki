package com.yuki.common.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepo<T, I extends Serializable> extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
    T findOrThrowErrorById(I id);
}