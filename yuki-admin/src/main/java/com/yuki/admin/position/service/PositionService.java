package com.yuki.admin.position.service;

import com.yuki.admin.position.web.PositionParam;
import com.yuki.admin.position.dao.Position;
import com.yuki.admin.position.dao.PositionRepo;
import com.yuki.common.core.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionService extends BaseService<PositionParam, PositionParam, Position> {
    private final PositionRepo repo;
    private final PositionMapper mapper;

    @Override
    protected PositionRepo getRepo() {
        return repo;
    }

    @Override
    protected Position onCreate(PositionParam param) {
        return mapper.paramToEntity(param);
    }

    @Override
    protected Position onUpdate(PositionParam param, Position entity) {
        mapper.paramToEntity(param, entity);
        return entity;
    }
}
