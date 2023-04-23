package com.yuki.admin.position.service;

import com.yuki.admin.position.dao.Position;
import com.yuki.admin.position.web.PositionParam;
import com.yuki.admin.position.web.PositionVO;
import com.yuki.common.core.mapper.BaseMapper;
import com.yuki.common.core.mapper.CustomMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, config = CustomMapperConfig.class)
public interface PositionMapper extends BaseMapper<Position, PositionVO> {
    @Override
    PositionVO convert(Position source);

    Position paramToEntity(PositionParam param);

    void paramToEntity(PositionParam param, @MappingTarget Position entity);
}
