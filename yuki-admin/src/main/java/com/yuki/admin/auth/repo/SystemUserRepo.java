package com.yuki.admin.auth.repo;

import com.yuki.common.core.repo.BaseRepo;
import com.yuki.admin.auth.domain.SystemUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepo extends BaseRepo<SystemUser, Long> {
    @Query("SELECT o from SystemUser o where o.username = :username")
    SystemUser findByUsername(@Param("username") String username);
}
