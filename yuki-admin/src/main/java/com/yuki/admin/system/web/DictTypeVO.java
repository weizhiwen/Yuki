package com.yuki.admin.system.web;

import com.yuki.admin.system.dao.DictType;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.BaseVO;

import java.time.LocalDateTime;

@RelatedClass(classes = DictType.class)
public class DictTypeVO extends BaseVO {
    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private String description;

    private LocalDateTime createdTime;

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
