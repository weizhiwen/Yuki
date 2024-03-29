package com.yuki.framework.dict.web;

import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.domain.BaseVO;

import java.io.Serial;
import java.time.LocalDateTime;

@RelatedClass(classes = DictType.class)
public class DictTypeVO extends BaseVO {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long parentId;

    private String parentType;

    private String parentName;

    private Boolean parentBuiltin;

    private String type;

    private String name;

    private Boolean disabled;

    private Boolean builtin;

    private String description;

    private LocalDateTime createdTime;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Boolean getParentBuiltin() {
        return parentBuiltin;
    }

    public void setParentBuiltin(Boolean parentBuiltin) {
        this.parentBuiltin = parentBuiltin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getBuiltin() {
        return builtin;
    }

    public void setBuiltin(Boolean builtin) {
        this.builtin = builtin;
    }
}
