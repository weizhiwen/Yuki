package com.yuki.admin.system.service;

import com.yuki.admin.system.dao.DictData;
import com.yuki.admin.system.dao.DictDataRepo;
import com.yuki.admin.system.dao.DictType;
import com.yuki.admin.system.dao.DictTypeRepo;
import com.yuki.admin.system.web.DictDataParam;
import com.yuki.common.core.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictDataService extends BaseService<DictDataParam, DictDataParam, DictData> {
    final DictDataRepo repo;
    final DictTypeRepo dictTypeRepo;
    final DictDataMapper mapper;

    @Override
    protected DictDataRepo getRepo() {
        return repo;
    }

    @Override
    protected DictData onCreate(DictDataParam param) {
        DictData dictData = mapper.paramToEntity(param);
        DictType dictType = dictTypeRepo.findOrThrowErrorById(param.getDictTypeId());
        dictData.setDictType(dictType);
        return dictData;
    }

    @Override
    protected DictData onUpdate(DictDataParam param, DictData entity) {
        String code = entity.getCode();
        mapper.paramToEntity(param, entity);
        entity.setCode(code);
        return entity;
    }
}
