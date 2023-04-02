package com.ruoyi.common.core.service;

import com.ruoyi.common.core.domain.entity.BaseEntity;
import com.ruoyi.common.core.reader.BaseReader;


@SuppressWarnings("unchecked")
public class BaseService<T extends BaseEntity> {


    public void executeWithReader(BaseReader reader, Executable<T> executable) {
        T execute = executable.execute();
        reader.read(execute);
    }

}
