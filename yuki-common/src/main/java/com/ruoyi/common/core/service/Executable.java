package com.ruoyi.common.core.service;

@FunctionalInterface
public interface Executable<R> {
    R execute();
}
