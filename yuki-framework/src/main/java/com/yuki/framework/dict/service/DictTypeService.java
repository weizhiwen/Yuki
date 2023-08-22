package com.yuki.framework.dict.service;

import cn.hutool.core.text.CharSequenceUtil;
import com.yuki.common.core.dict.DictDataRepo;
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
    private final DictDataRepo dictDataRepo;

    @Override
    protected DictTypeRepo getRepo() {
        return repo;
    }

    @Override
    protected void validateOnCreate(DictTypeParam param) {
        super.validateOnCreate(param);
        validateTypeRepeat(param);
        validateNameRepeat(param);
    }

    private void validateTypeRepeat(DictTypeParam param) {
        long count = repo.countByType(param.getType());
        if (count > 0) {
            throw new BaseException("dict.type.type.repeat");
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
        dictType.setBuiltin(Boolean.FALSE);
        return dictType;
    }

    private DictType getParentDictTypeIfNecessary(DictTypeParam param) {
        if (param.getParentId() != null) {
            return repo.findOrThrowErrorById(param.getParentId());
        } else if (CharSequenceUtil.isNotEmpty(param.getParentType())) {
            DictType dictType = repo.findByType(param.getParentType());
            if (dictType == null) {
                throw new BaseException("dict.type.parent.type.not.found");
            }
        }
        return null;
    }

    @Override
    protected DictType onUpdate(DictTypeParam param, DictType entity) {
        if (!Objects.equals(param.getType(), entity.getType())) {
            validateTypeRepeat(param);
        }
        if (!Objects.equals(param.getName(), entity.getName())) {
            validateNameRepeat(param);
        }
        if (Boolean.TRUE.equals(entity.getBuiltin())) {
            throw new BaseException("dict.type.update.builtin.not.support");
        }
        DictType parentDictType = getParentDictTypeIfNecessary(param);
        entity.setParent(parentDictType);
        mapper.paramToEntity(param, entity);
        return entity;
    }

    @Override
    protected void validateOnDelete(DictType dictType) {
        super.validateOnDelete(dictType);
        if (Boolean.TRUE.equals(dictType.getBuiltin())) {
            throw new BaseException("dict.type.delete.builtin.not.support");
        }
        long count = repo.countByParent(dictType);
        if (count > 0) {
            throw new BaseException("dict.type.delete.exist.reference");
        }
        count = dictDataRepo.countByDictType(dictType);
        if (count > 0) {
            throw new BaseException("dict.type.delete.exist.data");
        }
    }
}
