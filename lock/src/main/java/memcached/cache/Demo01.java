package memcached.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xu on 2015/6/18.
 */
public class Demo01 {



    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("cache/applicationContext-memcached.xml");

        SpyMemcachedClient spyMemcachedClient = (SpyMemcachedClient) context.getBean("spyMemcachedClient");
        String key = "consumer:1";
        String value = "admin";

        spyMemcachedClient.set(key, 60 * 60 * 1, value);

        String result = spyMemcachedClient.get(key);
        //assertThat(result).isEqualTo(value);

        spyMemcachedClient.delete(key);
        result = spyMemcachedClient.get(key);
        //assertThat(result).isNull();
    }
}
