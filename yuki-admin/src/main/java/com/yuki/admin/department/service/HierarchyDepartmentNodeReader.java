package com.yuki.admin.department.service;

import com.yuki.admin.department.dao.Department;
import com.yuki.common.core.reader.BaseReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HierarchyDepartmentNodeReader extends BaseReader<Department, HierarchyDepartmentVO> {
}
