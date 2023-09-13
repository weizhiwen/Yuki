package com.yuki.admin.position.dao;

import com.yuki.admin.department.dao.Department;
import com.yuki.common.constant.Constants;
import com.yuki.common.core.dict.Dict;
import com.yuki.common.core.dict.DictReference;
import com.yuki.common.core.domain.entity.BaseEntity;
import com.yuki.common.core.domain.entity.CanDisableEntity;

import javax.persistence.*;
import java.io.Serial;

@Entity
@Table(name = "POSITION")
public class Position extends BaseEntity implements CanDisableEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    public static final String DEPARTMENT_SUFFIX = "department.";
    public static final String CODE_FIELD = "code";
    public static final String NAME_FIELD = "name";
    public static final String TITLE_FIELD = "title";
    public static final String PROPERTY_FIELD = "property";
    public static final String DISABLED_FIELD = "disabled";

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")
    private Department department;

    @Column(name = "CODE", length = Constants.MEDIUM_STRING_LENGTH, unique = true)
    private String code;

    @Column(name = "NAME", length = Constants.MEDIUM_STRING_LENGTH, nullable = false)
    private String name;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "POSITION_PROPERTY")
    @DictReference(type = "POSITION_PROPERTY")
    private Dict property;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_DISABLED", nullable = false)
    private Boolean disabled = Boolean.FALSE;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Dict getProperty() {
        return property;
    }

    public void setProperty(Dict property) {
        this.property = property;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
