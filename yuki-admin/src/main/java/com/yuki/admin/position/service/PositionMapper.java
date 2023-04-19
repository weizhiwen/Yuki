package com.yuki.admin.position.service;

import com.yuki.admin.position.controller.PositionParam;
import com.yuki.admin.position.controller.PositionVO;
import com.yuki.admin.position.dal.Position;
import com.yuki.common.core.mapper.BaseMapper;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PositionMapper extends BaseMapper<Position, PositionVO> {
    @Override
    PositionVO convert(Position source);

    @Mapping(target = "id", ignore = true)
    Position paramToEntity(PositionParam param);

    void paramToEntity(PositionParam param, @MappingTarget Position entity);
}
