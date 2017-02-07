package com.hopechart.sq.annotation.Demo4;

/**
 * 父类
 * @author crazy
 */
@InheritedTest("使用Inherited的注解 class")
@NoneInheritedTest("未使用Inherited的注解 class")
@DocumentedTest
public class Parent {

    @InheritedTest("使用Inherited的注解 method")
    @NoneInheritedTest("未使用Inherited的注解 method")
    public void childMethod(){

    }
    @InheritedTest("使用Inherited的注解 method2")
    @NoneInheritedTest("未使用Inherited的注解 method2")
    @DocumentedTest
    public void parentMethod(){

    }

    @InheritedTest("属性a使用Inherited的注解 field")
    @NoneInheritedTest("属性a未使用Inherited的注解 field")
    public String a;

    @InheritedTest("属性b使用Inherited的注解 field")
    @NoneInheritedTest("属性b未使用Inherited的注解 field")
    public String b;
}