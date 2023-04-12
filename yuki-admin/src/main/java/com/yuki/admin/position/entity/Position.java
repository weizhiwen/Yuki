package com.yuki.admin.position.entity;

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
}
