package com.hopechart.sq.annotation.Demo2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mingwei on 12/2/16.
 * <p/>
 * 姓名注解
 */
@Target(ElementType.FIELD)
//@Target({})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    String[] value() default {"ad","rw","jik"};
}
