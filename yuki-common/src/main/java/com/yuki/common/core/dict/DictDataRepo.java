package com.yuki.common.core.dict;

import com.yuki.common.core.dao.BaseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DictDataRepo extends BaseRepo<DictData, Long> {

    @Query("select count(o) from DictData o where o.dictType = :dictType and o.code = :code")
    long countByDictTypeAndCode(DictType dictType, String code);

    @Query("select o from DictData o where o.dictType.code = :dictTypeCode and o.code = :code")
    DictData findByDictTypeAndCode(String dictTypeCode, String code);
}
