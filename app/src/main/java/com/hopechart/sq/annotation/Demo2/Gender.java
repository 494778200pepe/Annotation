package com.hopechart.sq.annotation.Demo2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mingwei on 12/2/16.
 * 性别注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Gender {

    public enum GenderType {

        Male("男"),
        Female("女"),
        Other("中性");

        private String genderStr;

        private GenderType(String arg0) {
            this.genderStr = arg0;
        }

        @Override
        public String toString() {
            return genderStr;
        }
    }

    GenderType gender() default GenderType.Male;

}