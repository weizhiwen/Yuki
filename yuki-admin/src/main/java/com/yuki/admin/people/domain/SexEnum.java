package com.yuki.admin.people.domain;

public enum SexEnum {
    MALE("男"), FEMALE("女");


    private final String name;

    SexEnum(String name) {
        this.name = name;
    }
}
