package com.yuki.framework.dict.service;

import com.yuki.common.core.exception.BaseException;
import com.yuki.framework.dict.web.DictTypeParam;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.dict.DictTypeRepo;
import com.yuki.common.core.service.BaseBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    protected void validateOnCreate(DictTypeParam param) {
        super.validateOnCreate(param);
        validateCodeRepeat(param);
        validateNameRepeat(param);
    }

    private void validateCodeRepeat(DictTypeParam param) {
        long count = repo.countByCode(param.getCode());
        if (count > 0) {
            throw new BaseException("dict.type.code.repeat");
        }
    }

    private void validateNameRepeat(DictTypeParam param) {
        long count = repo.countByName(param.getName());
        if (count > 0) {
            throw new BaseException("dict.type.name.repeat");
        }
    }

    @Override
    protected DictType onCreate(DictTypeParam param) {
        DictType parentDictType = getParentDictTypeIfNecessary(param);
        DictType dictType = mapper.paramToEntity(param);
        dictType.setParent(parentDictType);
        return dictType;
    }

    private DictType getParentDictTypeIfNecessary(DictTypeParam param) {
        if (param.getParentDictTypeId() != null) {
            return repo.findOrThrowErrorById(param.getParentDictTypeId());
        } else if (param.getParentDictTypeCode() != null) {
            DictType dictType = repo.findByCode(param.getParentDictTypeCode());
            if (dictType == null) {
                throw new BaseException("dict.type.parent.type.not.found");
            }
        }
        return null;
    }

    @Override
    protected DictType onUpdate(DictTypeParam param, DictType entity) {
        if (!Objects.equals(param.getCode(), entity.getCode())) {
            validateCodeRepeat(param);
        }
        if (!Objects.equals(param.getName(), entity.getName())) {
            validateNameRepeat(param);
        }
        mapper.paramToEntity(param, entity);
        return entity;
    }
}
