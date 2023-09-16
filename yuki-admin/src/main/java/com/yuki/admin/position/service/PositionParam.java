package com.yuki.admin.position.service;

import com.yuki.admin.position.dao.Position;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.Dict;
import com.yuki.common.core.domain.CreateOrUpdateParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RelatedClass(classes = Position.class)
public class PositionParam extends CreateOrUpdateParam {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "部门不能为空")
    private Long departmentId;

    @NotNull(message = "编码不能为空")
    private String code;

    @NotNull(message = "名称不能为空")
    private String name;

    private String title;

    private Dict property;

    @Size(max = 255, message = "描述超过最大长度")
    private String description;

    @NotNull(message = "是否禁用不能为空")
    private Boolean disabled = Boolean.FALSE;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
