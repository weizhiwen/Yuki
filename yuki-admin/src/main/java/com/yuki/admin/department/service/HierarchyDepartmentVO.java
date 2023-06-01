package com.yuki.admin.department.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yuki.admin.department.dao.Department;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.BaseVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RelatedClass(classes = Department.class)
public class HierarchyDepartmentVO extends BaseVO {
    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private boolean disabled;

    private List<HierarchyDepartmentVO> children;

    @JsonIgnore
    private int depth;

    @JsonIgnore
    private BigDecimal left;

    @JsonIgnore
    private BigDecimal right;

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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<HierarchyDepartmentVO> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void setChildren(List<HierarchyDepartmentVO> children) {
        this.children = children;
    }

    public void addChild(HierarchyDepartmentVO child) {
        getChildren().add(child);
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
