package com.yuki.admin.system.web;

import com.yuki.admin.system.dao.DictData;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.CreateOrUpdateParam;

import javax.validation.constraints.NotNull;

@RelatedClass(classes = DictData.class)
public class DictDataParam extends CreateOrUpdateParam {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "字典类型必填")
    private Long dictTypeId;

    private String code;

    private String name;

    private String memo;

    private Long idx;

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

    public Long getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(Long dictTypeId) {
        this.dictTypeId = dictTypeId;
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
