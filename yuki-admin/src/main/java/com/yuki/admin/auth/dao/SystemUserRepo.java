package com.yuki.admin.auth.dao;

import com.yuki.common.core.dao.BaseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepo extends BaseRepo<SystemUser, Long> {
    @Query("SELECT o from SystemUser o where o.tel = :loginName or o.email = :loginName")
    SystemUser findByLoginName(@Param("loginName") String loginName);
}
