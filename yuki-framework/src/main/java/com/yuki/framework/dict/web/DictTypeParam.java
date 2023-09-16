package com.yuki.framework.dict.web;

import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.dict.DictType;
import com.yuki.common.core.domain.CreateOrUpdateParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;

@RelatedClass(classes = DictType.class)
public class DictTypeParam extends CreateOrUpdateParam {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long parentId;

    private String parentType;

    @NotNull(message = "类型不能为空")
    private String type;

    @NotNull(message = "名称不能为空")
    private String name;

    @Size(max = 255, message = "描述超过最大长度")
    private String description;

    @NotNull(message = "是否禁用不能为空")
    private Boolean disabled = Boolean.FALSE;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
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

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
