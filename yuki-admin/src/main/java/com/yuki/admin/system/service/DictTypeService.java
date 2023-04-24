package com.yuki.admin.system.service;

import com.yuki.admin.system.dao.DictType;
import com.yuki.admin.system.dao.DictTypeRepo;
import com.yuki.admin.system.web.DictTypeParam;
import com.yuki.common.core.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictTypeService extends BaseService<DictTypeParam, DictTypeParam, DictType> {
    final DictTypeRepo repo;
    final DictTypeMapper mapper;

    @Override
    protected DictTypeRepo getRepo() {
        return repo;
    }

    @Override
    protected DictType onCreate(DictTypeParam param) {
        return mapper.paramToEntity(param);
    }

    @Override
    protected DictType onUpdate(DictTypeParam param, DictType entity) {
        mapper.paramToEntity(param, entity);
        return entity;
    }
}
