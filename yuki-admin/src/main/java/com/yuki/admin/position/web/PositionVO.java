package com.yuki.admin.position.web;

import com.yuki.admin.position.dao.Position;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.Dict;
import com.yuki.common.core.domain.BaseVO;

import java.time.LocalDateTime;

@RelatedClass(classes = Position.class)
public class PositionVO extends BaseVO {
    private String code;

    private String name;

    private String idx;

    private boolean disabled;

    private LocalDateTime createdTime;

    private Dict jobProfile;

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

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Dict getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(Dict jobProfile) {
        this.jobProfile = jobProfile;
    }
}
