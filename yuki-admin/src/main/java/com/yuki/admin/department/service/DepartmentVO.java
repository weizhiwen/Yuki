package com.yuki.admin.department.service;

import com.yuki.admin.department.dao.Department;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.BaseAuditVO;

@RelatedClass(classes = Department.class)
public class DepartmentVO extends BaseAuditVO {
    private static final long serialVersionUID = 1L;

    private SimpleDepartmentVO parent;

    private String code;

    private String name;

    private Long idx;

    private boolean disabled;

    public SimpleDepartmentVO getParent() {
        return parent;
    }

    public void setParent(SimpleDepartmentVO parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
