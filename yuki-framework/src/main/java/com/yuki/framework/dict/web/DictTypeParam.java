package com.yuki.framework.dict.web;

import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.domain.CreateOrUpdateParam;

import javax.validation.constraints.NotNull;
import java.io.Serial;

@RelatedClass(classes = DictType.class)
public class DictTypeParam extends CreateOrUpdateParam {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long parentId;

    private String parentCode;

    @NotNull(message = "编码不能为空")
    private String code;

    @NotNull(message = "名称不能为空")
    private String name;

    private String description;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
