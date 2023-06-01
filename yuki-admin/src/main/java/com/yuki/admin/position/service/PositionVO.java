package com.yuki.admin.position.service;

import com.yuki.admin.position.dao.Position;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.Dict;
import com.yuki.common.core.domain.BaseAuditVO;

@RelatedClass(classes = Position.class)
public class PositionVO extends BaseAuditVO {
    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private Long idx;

    private boolean disabled;

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

    public Dict getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(Dict jobProfile) {
        this.jobProfile = jobProfile;
    }
}
