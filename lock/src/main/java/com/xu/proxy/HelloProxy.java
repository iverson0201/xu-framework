package com.xu.proxy;

/**
 * Created by xu on 2015/6/5.
 */
public class HelloProxy implements Hello{
    private HelloImpl helloImpl;

    public HelloProxy() {
        this.helloImpl = new HelloImpl();
    }
    public void say(String name) {
        before();
        helloImpl.say(name);
        after();
    }

    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Befor");
    }
}
