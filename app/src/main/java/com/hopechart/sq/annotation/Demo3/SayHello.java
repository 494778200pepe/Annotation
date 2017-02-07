package com.hopechart.sq.annotation.Demo3;

/**
 * Created by wang on 2017/2/6.
 */

@Yts(classType = Yts.YtsType.util)
public class SayHello {

    @HelloWorld(name = " 小明 ")
    @Yts
    public void sayHello(String name) {
        if (name == null || name.equals("")) {
            System.out.println("hello world!");
        } else {
            System.out.println(name + "say hello world!");
        }
    }
}