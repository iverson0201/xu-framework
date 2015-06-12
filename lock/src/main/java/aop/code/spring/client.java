package aop.code.spring;

import aop.code.Greeting;
import aop.code.GreetingImpl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xu on 2015/6/8.
 * http://my.oschina.net/huangyong/blog/161402?p=4#comments
 */
public class client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        //proxyFactory.addAdvice(new GreetingBeforeAdvice());
        //proxyFactory.addAdvice(new GreetingAfterAdvice());

        //proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());

        //proxyFactory.addAdvice(new GreetingAroundAdvice());

        //Greeting greeting = (Greeting) proxyFactory.getProxy();
        //greeting.sayHello("spring proxy");


        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo/spring.xml");
        //Greeting greetingProxy = (Greeting) context.getBean("greetingProxy");
        //greetingProxy.sayHello("aop");

        Greeting greeting = (Greeting) context.getBean("greetingImpl");
        greeting.sayHello("aspectJ");

        Apology apology = (Apology) greeting;
        apology.saySorry("DeclareParents");

    }
}
