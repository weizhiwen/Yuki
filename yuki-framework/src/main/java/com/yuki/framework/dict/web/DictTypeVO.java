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

    private String parentCode;

    private String parentName;

    private String code;

    private String name;

    private String description;

    private LocalDateTime createdTime;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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
}
