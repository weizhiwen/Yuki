package com.yuki.admin.system.service;

import com.yuki.admin.system.dao.DictType;
import com.yuki.admin.system.web.DictTypeParam;
import com.yuki.admin.system.web.DictTypeVO;
import com.yuki.common.core.mapper.BaseMapper;
import com.yuki.common.core.mapper.CustomMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, config = CustomMapperConfig.class)
public interface DictTypeMapper extends BaseMapper<DictType, DictTypeVO> {
    @Override
    DictTypeVO convert(DictType source);

    DictType paramToEntity(DictTypeParam param);

    void paramToEntity(DictTypeParam param, @MappingTarget DictType entity);
}
