package com.yuki.admin.department.dao;

import com.yuki.common.core.dao.BaseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DepartmentRepo extends BaseRepo<Department, Long> {
    @Query("select max(o.right) from Department o where o.parent = :parent")
    BigDecimal getDirectChildrenMaxRight(Department parent);
}
