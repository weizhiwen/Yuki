package com.yuki.framework.dict.web;

import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.domain.BaseVO;

import java.time.LocalDateTime;

@RelatedClass(classes = DictData.class)
public class DictDataVO extends BaseVO {
    private static final long serialVersionUID = 1L;

    private Long dictTypeId;

    private String dictTypeType;

    private String dictTypeName;

    private String parentCode;

    private String parentName;

    private String code;

    private String name;

    private String description;

    private Long idx;

    private Boolean disabled;

    private LocalDateTime createdTime;

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

    public Long getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(Long dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    public String getDictTypeType() {
        return dictTypeType;
    }

    public void setDictTypeType(String dictTypeType) {
        this.dictTypeType = dictTypeType;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
