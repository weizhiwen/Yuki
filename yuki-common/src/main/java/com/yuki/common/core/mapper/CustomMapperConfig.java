package com.yuki.common.core.mapper;

import com.yuki.common.core.domain.UpdateParam;
import com.yuki.common.core.domain.entity.BaseEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;

@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface CustomMapperConfig {
    @Mapping(target = "id", ignore = true)
    BaseEntity paramToEntity(UpdateParam param);
}
