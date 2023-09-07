package com.yuki.common.core.dao;

import com.yuki.common.core.domain.entity.SortableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface SortRepo<T extends SortableEntity, I extends Serializable> extends JpaRepository<T, I> {
    @Query("SELECT MAX(e.idx) FROM #{#entityName} e")
    Integer findMaxIdx();
}