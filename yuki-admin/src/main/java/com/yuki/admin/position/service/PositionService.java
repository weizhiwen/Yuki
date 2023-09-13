package com.yuki.admin.position.service;

import com.yuki.admin.department.dao.Department;
import com.yuki.admin.department.dao.DepartmentRepo;
import com.yuki.admin.position.dao.Position;
import com.yuki.admin.position.dao.PositionRepo;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.service.BaseBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PositionService extends BaseBusinessService<PositionParam, PositionParam, Position, PositionVO> {
    private final PositionRepo repo;
    private final PositionMapper mapper;
    private final DepartmentRepo departmentRepo;

    @Override
    protected PositionRepo getRepo() {
        return repo;
    }

    @Override
    protected PositionMapper getMapper() {
        return mapper;
    }

    @Override
    protected void validateCreateParam(PositionParam param) {
        super.validateCreateParam(param);
        checkCodeRepeat(param);
    }

    private void checkCodeRepeat(PositionParam param) {
        long count = repo.countByCode(param.getCode());
        if (count > 0) {
            throw new BaseException("position.code.repeat");
        }
    }

    @Override
    protected Position onCreate(PositionParam param) {
        Position position = super.onCreate(param);
        Department department = departmentRepo.findOrThrowErrorById(param.getDepartmentId());
        position.setDepartment(department);
        return position;
    }

    @Override
    protected void validateOnUpdate(PositionParam param, Position entity) {
        super.validateOnUpdate(param, entity);
        if (!Objects.equals(param.getCode(), entity.getCode())) {
            checkCodeRepeat(param);
        }
    }
}
