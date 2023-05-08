package com.yuki.common.core.dict;

import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "DICT_DATA")
public class DictData extends BaseEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "DICT_ID", referencedColumnName = "ID")
    private DictType dictType;

    @Column(nullable = false, unique = true, length = 32)
    private String code;

    @Column(nullable = false, unique = true, length = 64)
    private String name;

    @Column(length = 255)
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
