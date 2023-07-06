package com.yuki.common.core.mapper;

import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;

public interface CommonMapper<S, T> extends Converter<S, T> {
    T map(S s);

    S reviseMap(T t);

    void map(S s, @MappingTarget T t);

    void reviseMap(T t, @MappingTarget S s);

}
