package com.yuki.admin.position.dal;

import com.yuki.admin.position.dal.Position;
import com.yuki.common.core.repo.BaseRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends BaseRepo<Position, Long> {
}
