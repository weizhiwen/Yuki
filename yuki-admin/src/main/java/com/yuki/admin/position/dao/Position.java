package com.yuki.admin.position.dao;

import com.yuki.common.core.dict.Dict;
import com.yuki.common.core.dict.DictReference;
import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "POSITION")
public class Position extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "CODE", length = 32, unique = true)
    private String code;

    @Column(name = "NAME", length = 32, unique = true)
    private String name;

    @Column(name = "IDX")
    private Long idx;

    @Column(name = "IS_DISABLE")
    private boolean disabled;

    @Column(name = "MEMO")
    private String memo;

    @Column(name = "JOB_PROFILE")
    @DictReference(type = "JOB_PROFILE")
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Dict getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(Dict jobProfile) {
        this.jobProfile = jobProfile;
    }
}
