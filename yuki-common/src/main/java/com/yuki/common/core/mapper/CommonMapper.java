package com.yuki.common.core.mapper;

import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;

public interface CommonMapper<S, T> extends Converter<S, T> {
    public abstract T map(S s);

    public abstract S reviseMap(T t);

    public abstract void map(S s, @MappingTarget T t);

    public abstract void reviseMap(T t, @MappingTarget S s);

}