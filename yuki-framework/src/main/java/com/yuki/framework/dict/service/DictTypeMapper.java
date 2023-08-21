package com.yuki.framework.dict.service;

import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.mapper.BusinessMapper;
import com.yuki.framework.dict.web.DictTypeParam;
import com.yuki.framework.dict.web.DictTypeVO;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictTypeMapper extends BusinessMapper<DictType, DictTypeParam, DictTypeParam, DictTypeVO> {
    @Override
    @Mappings({
            @Mapping(source = "parent.id", target = "parentId"),
            @Mapping(source = "parent.type", target = "parentType"),
            @Mapping(source = "parent.name", target = "parentName"),
    })
    DictTypeVO convert(DictType source);
}
