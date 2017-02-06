package com.hopechart.sq.annotation;

import com.hopechart.sq.annotation.Demo1.AnnatDemo;
import com.hopechart.sq.annotation.Demo1.IClientProtocolEx;
import com.hopechart.sq.annotation.Demo2.CustomUtils;
import com.hopechart.sq.annotation.Demo2.Person;
import com.hopechart.sq.annotation.Demo3.ParseAnnotation;
import com.hopechart.sq.annotation.Demo3.SayHell;

import java.lang.reflect.Method;

/**
 * Created by wang on 2017/2/6.
 */

public class Test {
    public static void main(String arg[]) {
        testDemo1();
        testDemo2();
        testDemo3();
    }

    private static void testDemo1() {
        Class ipt = IClientProtocolEx.class;
        Method[] mts = ipt.getMethods();
        for (Method mt : mts) {
            AnnatDemo ad = mt.getAnnotation(AnnatDemo.class);//如果方法上  没有该注解  则返回null
            int value = ad.value();
            System.out.println("value:" + value);
        }
    }

    private static void testDemo2() {
        CustomUtils.getInfo(Person.class);
    }

    private static void testDemo3()  {
        try {
            ParseAnnotation parse = new ParseAnnotation();
            parse.parseMethod(SayHell.class);
            parse.parseType(SayHell.class);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
