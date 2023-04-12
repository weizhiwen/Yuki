package com.yuki.common.core.mapper;

import com.yuki.common.core.domain.entity.BaseEntity;
import org.springframework.core.convert.converter.Converter;

public interface BaseMapper<T extends BaseEntity, VO> extends Converter<T, VO> {
}
