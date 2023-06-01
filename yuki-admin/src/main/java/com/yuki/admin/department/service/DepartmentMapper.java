package com.yuki.admin.department.service;

import com.yuki.admin.department.dao.Department;
import com.yuki.common.core.mapper.BusinessMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper extends BusinessMapper<Department, DepartmentParam, DepartmentParam, DepartmentVO> {
}
