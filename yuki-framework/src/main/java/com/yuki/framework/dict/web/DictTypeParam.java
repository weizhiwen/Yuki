package com.yuki.framework.dict.web;

import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.domain.CreateOrUpdateParam;

import javax.validation.constraints.NotNull;

@RelatedClass(classes = DictType.class)
public class DictTypeParam extends CreateOrUpdateParam {
    private static final long serialVersionUID = 1L;

    private Long parentDictTypeId;

    private String parentDictTypeCode;

    @NotNull(message = "编码不能为空")
    private String code;

    @NotNull(message = "名称不能为空")
    private String name;

    private String description;

    public Long getParentDictTypeId() {
        return parentDictTypeId;
    }

    public void setParentDictTypeId(Long parentDictTypeId) {
        this.parentDictTypeId = parentDictTypeId;
    }

    public String getParentDictTypeCode() {
        return parentDictTypeCode;
    }

    public void setParentDictTypeCode(String parentDictTypeCode) {
        this.parentDictTypeCode = parentDictTypeCode;
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
