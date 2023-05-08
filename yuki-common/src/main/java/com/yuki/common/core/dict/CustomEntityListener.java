package com.yuki.common.core.dict;

import com.yuki.common.core.domain.entity.BaseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Configurable
public class CustomEntityListener {

    @Lazy
    @Autowired
    private DictDataRepo dictDataRepo;

    @PrePersist
    public void onPersist(BaseEntity entity) {
        System.out.println("pre persist");
    }

    @PreUpdate
    public void onUpdate(BaseEntity entity) {
        System.out.println("pre update");
    }

    @PostLoad
    public void onPostLoad(BaseEntity entity) throws InvocationTargetException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(DictReference.class)) {
                    String type = ((DictReference) annotation).type();
                    PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(entity.getClass(), field.getName());
                    if (propertyDescriptor != null && field.getType().equals(Dict.class)) {
                        Method readMethod = propertyDescriptor.getReadMethod();
                        if (readMethod != null) {
                            Dict dict = (Dict)readMethod.invoke(entity);
                            if (dict != null && dict.getCode() != null) {
                                DictData dictData = dictDataRepo.findByDictTypeAndCode(type, dict.getCode());
                                if (dictData != null) {
                                    dict.setName(dictData.getName());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
