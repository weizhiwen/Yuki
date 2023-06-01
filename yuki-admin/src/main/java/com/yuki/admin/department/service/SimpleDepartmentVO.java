package com.yuki.admin.department.service;

import com.yuki.admin.department.dao.Department;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.BaseVO;

@RelatedClass(classes = Department.class)
public class SimpleDepartmentVO extends BaseVO {
    private String code;

    private String name;

    private boolean disabled;


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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
