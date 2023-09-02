package com.yuki.admin.position.service;

import com.yuki.admin.position.dao.Position;
import com.yuki.admin.position.dao.PositionRepo;
import com.yuki.common.core.service.BaseBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionService extends BaseBusinessService<PositionParam, PositionParam, Position, PositionVO> {
    private final PositionRepo repo;
    private final PositionMapper mapper;

    @Override
    protected PositionRepo getRepo() {
        return repo;
    }

    @Override
    protected PositionMapper getMapper() {
        return mapper;
    }

}
