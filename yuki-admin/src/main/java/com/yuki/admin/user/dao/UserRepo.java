package com.yuki.admin.user.dao;

import com.yuki.common.core.dao.BaseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends BaseRepo<User, Long> {
    @Query("SELECT o from User o where o.tel = :loginName or o.email = :loginName")
    User findByLoginName(@Param("loginName") String loginName);
}
