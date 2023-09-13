package com.yuki.admin.department.service;

import com.yuki.admin.department.dao.Department;
import com.yuki.admin.department.dao.DepartmentRepo;
import com.yuki.common.constant.Constants;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.service.BaseBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService extends BaseBusinessService<DepartmentParam, DepartmentParam, Department, DepartmentVO> {
    private final DepartmentRepo repo;
    private final DepartmentMapper mapper;
    private final HierarchyDepartmentReader hierarchyReader;

    @Override
    protected DepartmentRepo getRepo() {
        return repo;
    }

    @Override
    protected DepartmentMapper getMapper() {
        return mapper;
    }

    @Override
    protected void validateCreateParam(DepartmentParam param) {
        super.validateCreateParam(param);
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
        Department department = super.onCreate(param);
        Department parent = getParent(param);
        department.setParent(parent);
        addToHierarchy(department, parent);
        return department;
    }

    private void addToHierarchy(Department department, Department parent) {
        if (parent == null) {
            department.setDepth(0);
            department.setLeft(BigDecimal.ONE);
            department.setRight(new BigDecimal(BigInteger.TWO));
            return;
        }
        department.setDepth(parent.getDepth() + 1);
        BigDecimal maxRight = parent.getRight();
        BigDecimal minLeft = repo.getDirectChildrenMaxRight(parent);
        if (minLeft == null) {
            minLeft = parent.getLeft();
        }
        BigDecimal divisor = Constants.DEPARTMENT_DIVISOR;
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
    protected void validateUpdateParam(DepartmentParam param) {
        super.validateUpdateParam(param);
        isExistRootDepartment(param);
    }

    @Transactional
    public HierarchyDepartmentVO hierarchy(Specification<Department> query) {
        List<Department> list = list(query, Sort.unsorted());
        hierarchyReader.read(list);
        return hierarchyReader.fetchTarget();
    }
}
