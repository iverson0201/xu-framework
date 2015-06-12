package aop.code;

import aop.code.spring.Apology;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xu on 2015/6/8.
 */
public class Client {
    public static void main(String[] args) {
        //Greeting greeetingProxy = new GreetingProxy(new GreetingImpl());
        //greeetingProxy.sayHello("Jack");

        //Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        //greeting.sayHello("JDK Proxy");

        //Greeting greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        //greeting.sayHello("CGLib Proxy");

        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo/spring.xml");
        //Greeting greeting = (Greeting) context.getBean("greetingProxy");
        //greeting.sayHello("spring aop");

        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy");
        greetingImpl.sayHello("jack");
        Apology apology = (Apology) greetingImpl;
        apology.saySorry("jack");
    }
}
