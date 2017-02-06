package com.hopechart.sq.annotation.Demo1;

/**
 * Created by wang on 2017/2/6.
 */

public interface IClientProtocolEx {

    int METHOD_START = 5;

    @AnnatDemo(METHOD_START)
    public String say(String person);
}
