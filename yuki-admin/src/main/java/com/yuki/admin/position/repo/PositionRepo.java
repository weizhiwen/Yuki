package com.yuki.admin.position.repo;

import com.yuki.admin.position.entity.Position;
import com.yuki.common.core.repo.BaseRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends BaseRepo<Position, Long> {
}
