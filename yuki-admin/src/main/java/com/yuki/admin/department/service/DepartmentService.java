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
        return mapper.paramToEntity(param);
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
    public HierarchyDepartmentVO hierarchy(Specification<Position> query) {
        List<Department> list = list(query);
        hierarchyReader.read(list);
        return hierarchyReader.fetchTarget();
    }
}
