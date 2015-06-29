package other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xu on 2015/6/29.
 */
public class HashMap01 {

    public static void main(String[] args) {
        Map<Person,String> testMap = new HashMap<Person, String>();
        Person p1 = new Person();
        p1.setName("Jakie");
        p1.setHeight(165);

        Person p2 = new Person();
        p2.setName("Jerry");
        p2.setHeight(175);

        Person p3 = new Person();
        p3.setName("Torres");
        p3.setHeight(160);

        System.out.println(p1 + ";hashcode:" + p1.hashCode() + "\n");
        System.out.println(p2 + ";hashcode:" + p2.hashCode() + "\n");
        System.out.println(p3 + ";hashcode:" + p3.hashCode() + "\n");

        System.out.println("************************");
        p2.setName("Jerry is now kelly");

        System.out.println("P2 hashcode after update:");
        System.out.println(p2 + ";hashcode:" + p2.hashCode() + "\n");


        System.out.println("**************************");
        System.out.println("Hash Code of elements in HashMap");

        for (Map.Entry<Person,String> entry : testMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + " : " + entry.getKey().hashCode());
        }

        System.out.println("**********************");
        String p = testMap.get(p2);
        System.out.println("Final Result:" + p);
    }
}
