package com.yuki.framework.dict.service;

import cn.hutool.core.util.StrUtil;
import com.yuki.framework.dict.web.DictDataParam;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.dict.DictDataRepo;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.dict.DictTypeRepo;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.service.BaseBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictDataService extends BaseBusinessService<DictDataParam, DictDataParam, DictData> {
    final DictDataRepo repo;
    final DictTypeRepo dictTypeRepo;
    final DictDataMapper mapper;

    @Override
    protected DictDataRepo getRepo() {
        return repo;
    }

    @Override
    protected void validateOnCreate(DictDataParam param) {
        super.validateOnCreate(param);
    }

    @Override
    protected DictData onCreate(DictDataParam param) {
        DictData dictData = mapper.paramToEntity(param);
        DictType dictType = getDictType(param);
        dictData.setDictType(dictType);
        long count = repo.countByDictTypeAndCode(dictType, param.getCode());
        if (count > 0) {
            throw new BaseException("dict.data.code.repeat", dictType.getName(), param.getCode());
        }
        return dictData;
    }

    private DictType getDictType(DictDataParam param) {
        DictType dictType = null;
        if (param.getDictTypeId() != null) {
            dictType = dictTypeRepo.findOrThrowErrorById(param.getDictTypeId());
        } else if (StrUtil.isNotBlank(param.getDictTypeCode())) {
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
        mapper.paramToEntity(param, entity);
        entity.setDictType(getDictType(param));
        entity.setCode(code);
        return entity;
    }
}
