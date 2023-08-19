package com.yuki.common.core.dict;

import com.yuki.common.core.dao.BaseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DictTypeRepo extends BaseRepo<DictType, Long> {
    @Query("SELECT count(o) from DictType o where o.code = :code")
    long countByCode(String code);

    @Query("SELECT o from DictType o where o.code = :code")
    DictType findByCode(String code);

    @Query("SELECT count(o) from DictType o where o.name = :name")
    long countByName(String name);
}
