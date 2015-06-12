package aop.code.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by xu on 2015/6/8.
 */
@Aspect
@Component
public class GreetingAspectJ {

    @DeclareParents(value = "aop.code.GreetingImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;

    //@Around("execution(* aop.code.GreetingImpl.*(..))")
    @Around("@annotation(aop.code.spring.Tag)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    private void after() {
        System.out.println("After222");
    }

    private void before() {
        System.out.println("Before");
    }
}
