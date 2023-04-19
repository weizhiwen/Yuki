package com.yuki.admin.position.controller;

import com.yuki.admin.position.dal.Position;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.CreateOrUpdateParam;

@RelatedClass(classes = Position.class)
public class PositionParam extends CreateOrUpdateParam {
    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private Long idx;

    private boolean disabled;

    private String memo;

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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
