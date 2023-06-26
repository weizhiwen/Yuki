package com.yuki.admin.department.service;

import cn.hutool.core.collection.CollUtil;
import com.yuki.admin.department.dao.Department;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.reader.BaseReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HierarchyDepartmentReader extends BaseReader<Department, HierarchyDepartmentVO> {
    final HierarchyDepartmentNodeReader nodeReader;

    @Override
    public void read(Iterable<Department> list) {
        nodeReader.read(list);
        List<HierarchyDepartmentVO> nodeList = nodeReader.fetchTargetList();
        HierarchyDepartmentVO vo =  buildHierarchy(nodeList);
        setTarget(vo);
    }

    private HierarchyDepartmentVO buildHierarchy(List<HierarchyDepartmentVO> nodeList) {
        if (CollUtil.isEmpty(nodeList)) {
            return null;
        }
        HierarchyDepartmentVO vo = new HierarchyDepartmentVO();
        nodeList.sort(Comparator.comparing(HierarchyDepartmentVO::getDepth));
        HierarchyDepartmentVO rootDepartment = nodeList.get(0);
        vo.setId(rootDepartment.getId());
        vo.setCode(rootDepartment.getCode());
        vo.setName(rootDepartment.getName());
        vo.setDisabled(rootDepartment.isDisabled());
        vo.setChildren(rootDepartment.getChildren());
        Map<Long, HierarchyDepartmentVO> map = nodeList.stream().collect(Collectors.toMap(HierarchyDepartmentVO::getId, Function.identity()));
        ArrayDeque<HierarchyDepartmentVO> stack = new ArrayDeque<>();
        stack.push(rootDepartment);
        for (HierarchyDepartmentVO node : nodeList) {
            if (node == rootDepartment) {
                continue;
            }
            HierarchyDepartmentVO current = map.get(node.getId());
            if(current == null){
                continue;
            }
            HierarchyDepartmentVO top = stack.peek();
            if (top == null) {
                continue;
            }
            if (node.getDepth() == top.getDepth() + 1) {
                top.addChild(node);
                stack.push(current);
            } else if (node.getDepth() <= top.getDepth()) {
                while (node.getDepth() != top.getDepth() + 1) {
                    stack.pop();
                    top = stack.peek();
                }
                top.addChild(current);
                stack.push(current);
            } else {
                throw new BaseException("department.hierarchy.invalid");
            }
        }
        return vo;
    }
}
