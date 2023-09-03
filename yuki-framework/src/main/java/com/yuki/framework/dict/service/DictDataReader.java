package com.yuki.framework.dict.service;

import cn.hutool.core.text.CharSequenceUtil;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.dict.DictDataRepo;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.reader.BaseReader;
import com.yuki.framework.dict.web.DictDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictDataReader extends BaseReader<DictData, DictDataVO> {
    @Autowired
    private DictDataRepo repo;

    @Override
    protected void postDetails(DictData source, DictDataVO target) {
        super.postDetails(source, target);
        DictType dictType = source.getDictType();
        handleParent(source, target, dictType);
    }

    private void handleParent(DictData source, DictDataVO target, DictType dictType) {
        String parentCode = source.getParentCode();
        if (CharSequenceUtil.isEmpty(parentCode)) {
            return;
        }
        DictData dictData = repo.findByDictTypeAndCode(dictType.getParent(), parentCode);
        if (dictData != null) {
            target.setParentCode(dictData.getCode());
            target.setParentName(dictData.getName());
        }
    }
}
