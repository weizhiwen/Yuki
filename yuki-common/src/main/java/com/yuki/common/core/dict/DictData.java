package com.yuki.common.core.dict;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DICT_DATA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"DICT_TYPE_ID", "CODE"}),
        @UniqueConstraint(columnNames = {"DICT_TYPE_ID", "PARENT_CODE", "NAME"})
})
public class DictData extends BaseEntity {
    public static final String CODE_FIELD = "code";
    public static final String NAME_FIELD = "name";
    public static final String DISABLED_FIELD = "disabled";
    public static final String DICT_TYPE_FIELD_SUFFIX = "dictType.";

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "DICT_TYPE_ID", referencedColumnName = "ID")
    private DictType dictType;

    @Column(name = "PARENT_CODE", length = Constants.MEDIUM_STRING_LENGTH)
    private String parentCode;

    @Column(nullable = false, length = Constants.MEDIUM_STRING_LENGTH)
    private String code;

    @Column(nullable = false, length = Constants.LONG_STRING_LENGTH)
    private String name;

    @Column
    @Size(max = Constants.MAX_STRING_LENGTH, message = "{size.max.limit}")
    private String description;

    @Column(nullable = false)
    private Long idx;

    @Column(name = "IS_DISABLED", nullable = false)
    private Boolean disabled = Boolean.FALSE;

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
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

    public DictType getDictType() {
        return dictType;
    }

    public void setDictType(DictType dictType) {
        this.dictType = dictType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
