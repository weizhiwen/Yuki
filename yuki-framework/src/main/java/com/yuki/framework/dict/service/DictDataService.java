package com.yuki.framework.dict.service;

import cn.hutool.core.text.CharSequenceUtil;
import com.yuki.framework.dict.web.DictDataParam;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.dict.DictDataRepo;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.dict.DictTypeRepo;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.service.BaseBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DictDataService extends BaseBusinessService<DictDataParam, DictDataParam, DictData> {
    private final DictDataRepo repo;
    private final DictTypeRepo dictTypeRepo;
    private final DictDataMapper mapper;

    @Override
    protected DictDataRepo getRepo() {
        return repo;
    }

    @Override
    protected DictData onCreate(DictDataParam param) {
        DictData dictData = mapper.paramToEntity(param);
        DictType dictType = getDictType(param);
        validateParentCodeIfNecessary(param, dictType);
        dictData.setDictType(dictType);
        validateCodeRepeat(param, dictType);
        validateNameRepeat(param, dictType);
        return dictData;
    }

    private void validateCodeRepeat(DictDataParam param, DictType dictType) {
        long count = repo.countByDictTypeAndCode(dictType, param.getCode());
        if (count > 0) {
            throw new BaseException("dict.data.code.repeat", dictType.getName(), param.getCode());
        }
    }

    private void validateNameRepeat(DictDataParam param, DictType dictType) {
        long count = repo.countByDictTypeAndParentCodeAndName(dictType, param.getParentCode(), param.getName());
        if (count > 0) {
            throw new BaseException("dict.data.name.repeat", dictType.getName(), param.getCode());
        }
    }

    private void validateParentCodeIfNecessary(DictDataParam param, DictType dictType) {
        if (dictType.getParent() != null && CharSequenceUtil.isEmpty(param.getParentCode())) {
            throw new BaseException("dict.data.need.parent.code");
        }
    }

    private DictType getDictType(DictDataParam param) {
        DictType dictType = null;
        if (param.getDictTypeId() != null) {
            dictType = dictTypeRepo.findOrThrowErrorById(param.getDictTypeId());
        } else if (CharSequenceUtil.isNotBlank(param.getDictTypeCode())) {
            dictType = dictTypeRepo.findByCode(param.getDictTypeCode());
        }
        if (dictType == null) {
            throw new BaseException("dict.type.not.found");
        }
        return dictType;
    }

    @Override
    protected DictData onUpdate(DictDataParam param, DictData entity) {
        String code = entity.getCode();
        DictType dictType = entity.getDictType();
        validateParentCodeIfNecessary(param, dictType);
        if (!Objects.equals(param.getName(), entity.getName())) {
            validateNameRepeat(param, dictType);
        }
        mapper.paramToEntity(param, entity);
        entity.setDictType(dictType);
        entity.setCode(code);
        return entity;
    }
}
