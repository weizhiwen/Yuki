package com.ruoyi.common.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SoftDeleteEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "IS_DELETED")
    private boolean deleted;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
