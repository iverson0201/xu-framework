package aop.code.spring;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by xu on 2015/6/8.
 */
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method,Objects[] args,Object target,Exception e){
        System.out.println("--------Throw Exception--------");
        System.out.println("target class:" + target.getClass().getName());
        System.out.println("method name:" + method.getName());
        System.out.println("Exception Message:" + e.getMessage());
        System.out.println("-------------------------------");
    }
}
