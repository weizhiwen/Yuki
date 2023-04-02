package com.ruoyi.common.core.domain.entity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class TraceableEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String no;

    private LocalDate startDate;

    private LocalDate endDate;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
