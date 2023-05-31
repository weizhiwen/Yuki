package com.yuki.framework.dict.service;

import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.mapper.BusinessMapper;
import com.yuki.framework.dict.web.DictTypeParam;
import com.yuki.framework.dict.web.DictTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictTypeMapper extends BusinessMapper<DictType, DictTypeParam, DictTypeParam, DictTypeVO> {
}
