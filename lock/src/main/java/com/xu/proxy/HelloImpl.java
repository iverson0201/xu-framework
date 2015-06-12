package com.xu.proxy;

/**
 * Created by xu on 2015/6/5.
 */
public class HelloImpl implements Hello {
    public void say(String name) {
        System.out.println("Hello! " + name);
    }
}
