package com.yuki.common.core.dict;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "DICT_TYPE")
public class DictType extends BaseEntity {
    public static final String CODE_FIELD = "code";
    public static final String NAME_FIELD = "name";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private DictType parent;

    @Column(nullable = false, unique = true, length = Constants.MEDIUM_STRING_LENGTH)
    private String code;

    @Column(nullable = false, unique = true, length = Constants.LONG_STRING_LENGTH)
    private String name;

    @Column
    private String description;

    public DictType getParent() {
        return parent;
    }

    public void setParent(DictType parentDictType) {
        this.parent = parentDictType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
