package com.yuki.common.core.dict;

import com.yuki.common.core.domain.entity.BaseEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Lazy;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Configurable
public class CustomEntityListener {

    @Lazy
    @Autowired
    private DictDataRepo dictDataRepo;

    @PrePersist
    public void prePersist(BaseEntity entity) {
        System.out.println("pre persist");
    }

    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        System.out.println("pre update");
    }

    @PostLoad
    public void postLoad(BaseEntity entity) throws InvocationTargetException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            DictReference annotation = field.getAnnotation(DictReference.class);
            if (annotation == null || !field.getType().equals(Dict.class)) {
                continue;
            }

            String type = annotation.type();
            PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(entity.getClass(), field.getName());
            if (propertyDescriptor == null) {
                continue;
            }
            Method readMethod = propertyDescriptor.getReadMethod();
            if (readMethod == null) {
                continue;
            }
            Dict dict = (Dict) readMethod.invoke(entity);
            if (dict == null || StringUtils.isEmpty(dict.getCode())) {
                continue;
            }
            DictData dictData = dictDataRepo.findByDictTypeAndCode(type, dict.getCode());
            if (dictData != null) {
                dict.setName(dictData.getName());
            }
        }
    }
}
