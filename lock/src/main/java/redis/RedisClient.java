package redis;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by xu on 2015/6/17.
 * https://github.com/youngxiuxi/redis-demo/blob/master/src/com/tcl/redis/study/RedisClient.java
 */
public class RedisClient {

    private Jedis jedis;// 非切片额客户端连接
	private JedisPool jedisPool;// 非切片连接池
	private ShardedJedis shardedJedis;// 切片额客户端连接
	private ShardedJedisPool shardedJedisPool;// 切片连接池

	public RedisClient() {
		initialPool();
		initialShardedPool();
		shardedJedis = shardedJedisPool.getResource();
		jedis = jedisPool.getResource();

	}

	/**
	 * 初始化非切片池
	 */
	private void initialPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);

		jedisPool = new JedisPool(config, "127.0.0.1", 6379);
	}

	/**
	 * 初始化切片池
	 */
	private void initialShardedPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);
		// slave链接
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));

		// 构造池
		shardedJedisPool = new ShardedJedisPool(config, shards);
	}

    public void show(){
        keyOperate();
    }

    private void keyOperate() {
        System.out.println("--------------key-----------------");
        System.out.println("清空库中所有数据：" + jedis.flushDB());
        System.out.println("判断key999键是否存在：" + shardedJedis.exists("key999"));
		System.out.println("新增key001,value001键值对："
				+ shardedJedis.set("key001", "value001"));
		System.out.println("判断key001是否存在：" + shardedJedis.exists("key001"));
		System.out.println("系统中所有键如下：");

		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()){
			String key = it.next();
			System.out.println(key);
		}

    }

}
