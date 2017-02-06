package com.hopechart.sq.annotation.Demo3;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wang on 2017/2/6.
 */

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Yts {
    enum YtsType {util, entity, service, YtsType, model}

    YtsType classType() default YtsType.util;
}