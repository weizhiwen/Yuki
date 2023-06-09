package com.yuki.framework.dict.service;

import com.yuki.framework.dict.web.DictTypeParam;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.dict.DictTypeRepo;
import com.yuki.common.core.service.BaseBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictTypeService extends BaseBusinessService<DictTypeParam, DictTypeParam, DictType> {
    private final DictTypeRepo repo;
    private final DictTypeMapper mapper;

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
