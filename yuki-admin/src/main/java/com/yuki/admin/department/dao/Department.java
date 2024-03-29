package com.yuki.admin.department.dao;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private Department parent;

    @Column(name = "CODE", length = Constants.MEDIUM_STRING_LENGTH, nullable = false, unique = true)
    private String code;

    @Column(name = "NAME", length = Constants.MEDIUM_STRING_LENGTH, nullable = false)
    private String name;

    @Column(name = "IDX", nullable = false)
    private Long idx;

    @Column(name = "DEPTH", nullable = false)
    private int depth;

    @Column(name = "C_LEFT", precision = Constants.BIG_DECIMAL_MAX_PRECISION, scale = Constants.BIG_DECIMAL_MAX_SCALE, nullable = false)
    private BigDecimal left;

    @Column(name = "C_RIGHT", precision = Constants.BIG_DECIMAL_MAX_PRECISION, scale = Constants.BIG_DECIMAL_MAX_SCALE, nullable = false)
    private BigDecimal right;

    @Column(name = "IS_DISABLED", nullable = false)
    private Boolean disabled = Boolean.FALSE;

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

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
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
