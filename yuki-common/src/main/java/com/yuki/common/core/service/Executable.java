package com.yuki.common.core.service;

@FunctionalInterface
public interface Executable<R> {
    R execute();
}
