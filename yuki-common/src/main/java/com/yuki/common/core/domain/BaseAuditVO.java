package com.yuki.common.core.domain;

import java.io.Serial;
import java.time.LocalDateTime;

public class BaseAuditVO extends BaseVO {
    @Serial
    private static final long serialVersionUID = 1L;

    private String createdUserId;

    private LocalDateTime createdTime;

    private String updatedUserId;

    private LocalDateTime updatedTime;

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
