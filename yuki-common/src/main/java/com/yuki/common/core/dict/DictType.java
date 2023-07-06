package com.yuki.common.core.dict;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DICT_TYPE")
public class DictType extends BaseEntity {
    public static final String CODE_FIELD = "code";
    public static final String NAME_FIELD = "name";
    @Column(nullable = false, unique = true, length = Constants.MEDIUM_STRING_LENGTH)
    private String code;

    @Column(nullable = false,unique = true, length = Constants.LONG_STRING_LENGTH)
    private String name;

    @Column
    private String description;

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
