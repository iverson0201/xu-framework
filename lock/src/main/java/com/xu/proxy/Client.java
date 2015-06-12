package com.xu.proxy;

/**
 * Created by xu on 2015/6/5.
 */
public class Client {
    public static void main(String[] args) {
        //HelloProxy proxy = new HelloProxy();
        //proxy.say("Iverson");
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        //Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),dynamicProxy);
        //helloProxy.say("tracy");

        //Hello helloProxy = dynamicProxy.getProxy();
        //helloProxy.say("xujw");

        //CGLibProxy cgLibProxy = new CGLibProxy();
        //HelloImpl helloImpl = cgLibProxy.getProxy(HelloImpl.class);
        //helloImpl.say("cglib proxy");

        HelloImpl helloImpl = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloImpl.say("cglib good");
    }
}
