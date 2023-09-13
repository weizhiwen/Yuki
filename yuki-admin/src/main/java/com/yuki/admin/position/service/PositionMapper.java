package com.yuki.admin.position.service;

import com.yuki.admin.position.dao.Position;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.mapper.BusinessMapper;
import com.yuki.framework.dict.web.DictDataVO;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PositionMapper extends BusinessMapper<Position, PositionParam, PositionParam, PositionVO> {
    @Override
    @Mappings({
            @Mapping(source = "department.id", target = "departmentId"),
            @Mapping(source = "department.code", target = "departmentCode"),
            @Mapping(source = "department.name", target = "departmentName"),
    })
    PositionVO convert(Position source);
}
