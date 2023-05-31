package com.yuki.common.core.mapper;

import com.yuki.common.core.domain.CreateParam;
import com.yuki.common.core.domain.UpdateParam;
import com.yuki.common.core.domain.entity.BaseEntity;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;

public interface BusinessMapper<E extends BaseEntity, C extends CreateParam, U extends UpdateParam, V> extends Converter<E, V> {
    @Mapping(target = "id", ignore = true)
    E paramToEntity(C c);

    @Mapping(target = "id", ignore = true)
    void paramToEntity(U u, @MappingTarget E e);
}
