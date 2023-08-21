package com.yuki.common.core.dict;

import com.yuki.common.core.dao.BaseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DictTypeRepo extends BaseRepo<DictType, Long> {
    @Query("SELECT count(o) from DictType o where o.type = :type")
    long countByType(String type);

    @Query("SELECT o from DictType o where o.type = :type")
    DictType findByType(String type);

    @Query("SELECT count(o) from DictType o where o.name = :name")
    long countByName(String name);

    @Query("SELECT count(o) from DictType o where o.parent = :parent")
    long countByParent(DictType parent);
}
