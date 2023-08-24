package com.yuki.admin.employee.dao;

public enum SexEnum {
    MALE("男"), FEMALE("女");

    private final String name;

    public String getName() {
        return name;
    }

    SexEnum(String name) {
        this.name = name;
    }
}
