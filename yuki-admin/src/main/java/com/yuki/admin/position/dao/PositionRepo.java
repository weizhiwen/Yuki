package com.yuki.admin.position.dao;

import com.yuki.common.core.dao.BaseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends BaseRepo<Position, Long> {
    @Query("select count(o) from Position o where o.code = :code")
    long countByCode(@Param("code") String code);
}
