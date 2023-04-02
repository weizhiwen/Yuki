package com.ruoyi.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface RelatedClass {
    Class[] classes() default {};
}
