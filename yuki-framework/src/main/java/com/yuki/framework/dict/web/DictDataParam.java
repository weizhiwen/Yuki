package com.yuki.framework.dict.web;

import cn.hutool.core.text.CharSequenceUtil;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.domain.CreateOrUpdateParam;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RelatedClass(classes = DictData.class)
public class DictDataParam extends CreateOrUpdateParam {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "字典类型不能为空")
    @AssertTrue(message = "字典类型不能为空")
    public boolean dictTypeNotNull() {
        return dictTypeId != null || CharSequenceUtil.isNotBlank(dictTypeType);
    }

    private Long dictTypeId;

    private String dictTypeType;

    private String parentCode;

    @NotNull(message = "枚举编码不能为空")
    private String code;

    @NotNull(message = "枚举名称不能为空")
    private String name;

    @Size(max = 255, message = "描述超过最大长度")
    private String description;

    private Integer idx;

    @NotNull(message = "是否禁用不能为空")
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

    public Long getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(Long dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    public String getDictTypeType() {
        return dictTypeType;
    }

    public void setDictTypeType(String dictTypeType) {
        this.dictTypeType = dictTypeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
