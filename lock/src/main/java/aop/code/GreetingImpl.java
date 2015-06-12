package aop.code;

import aop.code.spring.Tag;
import org.springframework.stereotype.Component;

/**
 * Created by xu on 2015/6/8.
 */
@Component
public class GreetingImpl implements Greeting {
    @Tag
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
        //throw new RuntimeException("Error");
    }

    public void goodMorning(String name){
        System.out.println("Good Morning! " + name);
    }

    public void goodNight(String name){
        System.out.println("Good Night! " + name);
    }
}
