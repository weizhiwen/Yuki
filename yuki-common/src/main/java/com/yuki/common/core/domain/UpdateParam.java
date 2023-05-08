package com.yuki.common.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UpdateParam extends CreateParam {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
