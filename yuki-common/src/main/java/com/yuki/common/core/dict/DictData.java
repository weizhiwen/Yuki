package com.yuki.common.core.dict;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "DICT_DATA")
public class DictData extends BaseEntity {
    public static final String CODE_FIELD = "code";
    public static final String NAME_FIELD = "name";
    @ManyToOne(optional = false)
    @JoinColumn(name = "DICT_ID", referencedColumnName = "ID")
    private DictType dictType;

    @Column(nullable = false, unique = true, length = Constants.MEDIUM_STRING_LENGTH)
    private String code;

    @Column(nullable = false, unique = true, length = Constants.LONG_STRING_LENGTH)
    private String name;

    @Column(length = Constants.MAX_STRING_LENGTH)
    private String memo;

    @Column(nullable = false)
    private Long idx;

    @Column(nullable = false)
    private Boolean disabled;

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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
