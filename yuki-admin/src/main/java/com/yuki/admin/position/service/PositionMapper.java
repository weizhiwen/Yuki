package com.yuki.admin.position.service;

import com.yuki.admin.position.dao.Position;
import com.yuki.common.core.mapper.BusinessMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PositionMapper extends BusinessMapper<Position, PositionParam, PositionParam, PositionVO> {
}
