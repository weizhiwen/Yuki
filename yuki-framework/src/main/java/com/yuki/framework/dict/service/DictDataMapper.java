package com.yuki.framework.dict.service;

import com.yuki.framework.dict.web.DictDataParam;
import com.yuki.framework.dict.web.DictDataVO;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.mapper.BaseMapper;
import com.yuki.common.core.mapper.CustomMapperConfig;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, config = CustomMapperConfig.class)
public interface DictDataMapper extends BaseMapper<DictData, DictDataVO> {
    @Override
    @Mappings({
            @Mapping(source = "dictType.id", target = "dictTypeId"),
            @Mapping(source = "dictType.code", target = "dictTypeCode"),
            @Mapping(source = "dictType.name", target = "dictTypeName"),
    })
    DictDataVO convert(DictData source);

    DictData paramToEntity(DictDataParam param);

    void paramToEntity(DictDataParam param, @MappingTarget DictData entity);
}
