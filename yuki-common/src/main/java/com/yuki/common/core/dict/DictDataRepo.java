package com.yuki.common.core.dict;

import com.yuki.common.core.dao.BaseRepo;
import com.yuki.common.core.dao.SortRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DictDataRepo extends BaseRepo<DictData, Long>, SortRepo<DictData, Long> {

    @Query("select count(o) from DictData o where o.dictType = :dictType and o.code = :code")
    long countByDictTypeAndCode(DictType dictType, String code);

    @Query("select o from DictData o where o.dictType = :dictType and o.code = :code")
    DictData findByDictTypeAndCode(DictType dictType, String code);

    @Query("select count(o) from DictData o where o.dictType = :dictType and o.parentCode = :parentCode and o.name = :name")
    long countByDictTypeAndParentCodeAndName(DictType dictType, String parentCode, String name);

    @Query("select o from DictData o where o.dictType.type = :dictTypeType and o.code = :code")
    DictData findByDictTypeCodeAndCode(String dictTypeType, String code);

    @Query("select count(o) from DictData o where o.dictType = :dictType")
    long countByDictType(DictType dictType);
}
