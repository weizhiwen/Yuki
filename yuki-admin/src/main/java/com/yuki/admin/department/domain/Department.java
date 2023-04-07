package com.yuki.admin.department.domain;

import com.ruoyi.common.core.domain.entity.BaseEntity;
import com.ruoyi.common.core.domain.entity.TraceableEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private Department parent;

    @Column(name = "CODE", length = 32, unique = true)
    private String code;

    @Column(name = "NAME", length = 32)
    private String name;

    @Column(name = "IDX")
    private Long idx;

    @Column(name = "IS_DISABLE")
    private boolean disabled;

    @Column(name = "C_LEFT", precision = 15, scale = 6)
    private BigDecimal left;

    @Column(name = "C_RIGHT", precision = 15, scale = 6)
    private BigDecimal right;

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
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

    public BigDecimal getLeft() {
        return left;
    }

    public void setLeft(BigDecimal left) {
        this.left = left;
    }

    public BigDecimal getRight() {
        return right;
    }

    public void setRight(BigDecimal right) {
        this.right = right;
    }
}
