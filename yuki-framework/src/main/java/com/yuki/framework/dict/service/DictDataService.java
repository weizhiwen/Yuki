package com.yuki.framework.dict.service;

import cn.hutool.core.text.CharSequenceUtil;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.dict.DictDataRepo;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.dict.DictTypeRepo;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.service.BaseBusinessService;
import com.yuki.framework.dict.web.DictDataParam;
import com.yuki.framework.dict.web.DictDataVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DictDataService extends BaseBusinessService<DictDataParam, DictDataParam, DictData, DictDataVO> {
    private final DictDataRepo repo;
    private final DictTypeRepo dictTypeRepo;
    private final DictDataMapper mapper;

    @Override
    protected DictDataRepo getRepo() {
        return repo;
    }

    @Override
    protected DictDataMapper getMapper() {
        return mapper;
    }

    @Override
    protected DictData onCreate(DictDataParam param) {
        DictData dictData = super.onCreate(param);
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
        if (dictType.getParent() == null) {
            return;
        }
        if (CharSequenceUtil.isEmpty(param.getParentCode())) {
            throw new BaseException("dict.data.need.parent.code");
        }
        long count = repo.countByDictTypeAndCode(dictType.getParent(), param.getParentCode());
        if (count == 0) {
            throw new BaseException("dict.data.parent.code.not.exist", param.getParentCode());
        }
    }

    private DictType getDictType(DictDataParam param) {
        DictType dictType = null;
        if (param.getDictTypeId() != null) {
            dictType = dictTypeRepo.findOrThrowErrorById(param.getDictTypeId());
        } else if (CharSequenceUtil.isNotBlank(param.getDictTypeType())) {
            dictType = dictTypeRepo.findByType(param.getDictTypeType());
        }
        if (dictType == null) {
            throw new BaseException("dict.type.not.found");
        }
        return dictType;
    }

    @Override
    protected void onUpdate(DictDataParam param, DictData entity) {
        super.onUpdate(param, entity);
        String code = entity.getCode();
        DictType dictType = entity.getDictType();
        validateParentCodeIfNecessary(param, dictType);
        if (!Objects.equals(param.getName(), entity.getName())) {
            validateNameRepeat(param, dictType);
        }
        entity.setDictType(dictType);
        entity.setCode(code);
    }
}
