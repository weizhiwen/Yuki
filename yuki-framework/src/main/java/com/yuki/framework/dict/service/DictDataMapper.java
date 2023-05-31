package com.yuki.framework.dict.service;

import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.mapper.BusinessMapper;
import com.yuki.framework.dict.web.DictDataParam;
import com.yuki.framework.dict.web.DictDataVO;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDataMapper extends BusinessMapper<DictData, DictDataParam, DictDataParam, DictDataVO> {
    @Override
    @Mappings({
            @Mapping(source = "dictType.id", target = "dictTypeId"),
            @Mapping(source = "dictType.code", target = "dictTypeCode"),
            @Mapping(source = "dictType.name", target = "dictTypeName"),
    })
    DictDataVO convert(DictData source);
}
