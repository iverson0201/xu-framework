package aop.code.spring;

/**
 * Created by xu on 2015/6/8.
 */
public class ApologyImpl implements Apology {
    public void saySorry(String name) {
        System.out.println("sorry! " + name);
    }
}
