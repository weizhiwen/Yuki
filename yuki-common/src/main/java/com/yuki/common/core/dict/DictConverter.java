package com.yuki.common.core.dict;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DictConverter implements AttributeConverter<Dict, String> {

    @Override
    public String convertToDatabaseColumn(Dict attribute) {
        return attribute.getCode();
    }

    @Override
    public Dict convertToEntityAttribute(String dbData) {
        return new Dict(dbData);
    }
}
