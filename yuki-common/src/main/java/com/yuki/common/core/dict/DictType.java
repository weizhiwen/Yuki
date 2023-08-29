package com.yuki.common.core.dict;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DICT_TYPE")
public class DictType extends BaseEntity {
    public static final String TYPE_FIELD = "type";
    public static final String NAME_FIELD = "name";
    public static final String ENABLED_FIELD = "enabled";
    public static final String BUILTIN_FIELD = "builtin";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private DictType parent;

    @Column(nullable = false, unique = true, length = Constants.MEDIUM_STRING_LENGTH)
    @Size(max = Constants.MEDIUM_STRING_LENGTH, message = "{size.max.limit}")
    private String type;

    @Column(nullable = false, unique = true, length = Constants.LONG_STRING_LENGTH)
    private String name;

    @Column
    @Size(max = Constants.MAX_STRING_LENGTH, message = "{size.max.limit}")
    private String description;

    @Column(name = "IS_ENABLED")
    private Boolean enabled = Boolean.TRUE;

    @Column(name = "IS_BUILTIN")
    private Boolean builtin = Boolean.FALSE;

    public DictType getParent() {
        return parent;
    }

    public void setParent(DictType parentDictType) {
        this.parent = parentDictType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getBuiltin() {
        return builtin;
    }

    public void setBuiltin(Boolean builtin) {
        this.builtin = builtin;
    }
}
