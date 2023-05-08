package com.yuki.framework.dict.web;

import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.domain.BaseVO;

import java.time.LocalDateTime;

@RelatedClass(classes = DictData.class)
public class DictDataVO extends BaseVO {
    private static final long serialVersionUID = 1L;

    private Long dictTypeId;

    private String dictTypeCode;

    private String dictTypeName;

    private String code;

    private String name;

    private String memo;

    private Long idx;

    private Boolean disabled;

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

    public Long getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(Long dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
