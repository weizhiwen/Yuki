package com.yuki.admin.system.service;

import com.yuki.admin.system.dao.DictData;
import com.yuki.admin.system.web.DictDataParam;
import com.yuki.admin.system.web.DictDataVO;
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
