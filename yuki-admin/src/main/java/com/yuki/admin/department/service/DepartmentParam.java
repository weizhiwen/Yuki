package com.yuki.admin.department.service;

import com.yuki.admin.department.dao.Department;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.CreateOrUpdateParam;

@RelatedClass(classes = Department.class)
public class DepartmentParam extends CreateOrUpdateParam {
    private static final long serialVersionUID = 1L;

    private Long parentId;

    private String code;

    private String name;

    private Long idx;

    private boolean disabled;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
