package com.yuki.admin.position.service;

import com.yuki.admin.position.dao.Position;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.Dict;
import com.yuki.common.core.domain.BaseAuditVO;

import java.io.Serial;

@RelatedClass(classes = Position.class)
public class PositionVO extends BaseAuditVO {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long departmentId;

    private String departmentCode;

    private String departmentName;

    private String departmentPath;

    private String code;

    private String name;

    private String title;

    private Dict property;

    private String description;

    private Boolean disabled = Boolean.FALSE;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentPath() {
        return departmentPath;
    }

    public void setDepartmentPath(String departmentPath) {
        this.departmentPath = departmentPath;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Dict getProperty() {
        return property;
    }

    public void setProperty(Dict property) {
        this.property = property;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
