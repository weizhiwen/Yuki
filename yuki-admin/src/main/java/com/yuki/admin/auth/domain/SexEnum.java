package com.yuki.admin.auth.domain;

public enum SexEnum {
    MALE("男"), FEMALE("女");


    private final String name;

    SexEnum(String name) {
        this.name = name;
    }
}
