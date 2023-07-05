package com.yuki.admin.department.service;

import com.yuki.admin.department.dao.Department;
import com.yuki.admin.department.dao.DepartmentRepo;
import com.yuki.admin.position.dao.Position;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.service.BaseBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService extends BaseBusinessService<DepartmentParam, DepartmentParam, Department> {
    final DepartmentRepo repo;
    final DepartmentMapper mapper;
    final HierarchyDepartmentReader hierarchyReader;

    @Override
    protected DepartmentRepo getRepo() {
        return repo;
    }

    @Override
    protected void validateOnCreate(DepartmentParam param) {
        super.validateOnCreate(param);
        isExistRootDepartment(param);
    }

    private void isExistRootDepartment(DepartmentParam param) {
        if (param.getParentId() == null) {
            long count = repo.count();
            if (count > 0) {
                throw new BaseException("department.root.exist");
            }
        }
    }

    @Override
    protected Department onCreate(DepartmentParam param) {
        Department department = mapper.paramToEntity(param);
        Department parent = getParent(param);
        department.setParent(parent);
        addToHierarchy(department, parent);
        return department;
    }

    private void addToHierarchy(Department department, Department parent) {
        if (parent == null) {
            department.setDepth(0);
            department.setLeft(new BigDecimal("1"));
            department.setRight(new BigDecimal("2"));
            return;
        }
        department.setDepth(parent.getDepth() + 1);
        BigDecimal maxRight = parent.getRight();
        BigDecimal minLeft = repo.getDirectChildrenMaxRight(parent);
        if (minLeft == null) {
            minLeft = parent.getLeft();
        }
        BigDecimal divisor = new BigDecimal(3);
        BigDecimal gap = maxRight.subtract(minLeft, MathContext.DECIMAL128).divide(divisor, MathContext.DECIMAL128);
        BigDecimal left = minLeft.add(gap, MathContext.DECIMAL128);
        BigDecimal right = maxRight.subtract(gap, MathContext.DECIMAL128);
        department.setLeft(left);
        department.setRight(right);
        // TODO: 考虑无法添加部门节点时报错
    }

    private Department getParent(DepartmentParam param) {
        if (param.getParentId() != null) {
            return repo.findOrThrowErrorById(param.getParentId());
        }
        return null;
    }

    @Override
    protected void validateOnUpdate(DepartmentParam param) {
        super.validateOnUpdate(param);
        isExistRootDepartment(param);
    }

    @Override
    protected Department onUpdate(DepartmentParam param, Department entity) {
        mapper.paramToEntity(param, entity);
        return entity;
    }

    @Transactional
    public HierarchyDepartmentVO hierarchy(Specification<Department> query) {
        List<Department> list = list(query);
        hierarchyReader.read(list);
        return hierarchyReader.fetchTarget();
    }
}
