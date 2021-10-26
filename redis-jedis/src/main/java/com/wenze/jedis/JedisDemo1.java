package com.wenze.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        // 创建Jedis对象
        Jedis jedis = new Jedis("192.168.229.129", 6379);
        // 测试
        String value = jedis.ping();
        System.out.println(value);
    }

    // 操作key String类型
    @Test
    public void useString(){
        // 创建Jedis对象
        Jedis jedis = new Jedis("192.168.229.129", 6379);

        // 添加数据
        jedis.set("name", "zhangsan");

        // 获取数据
        String name = jedis.get("name");
        System.out.println(name);

        // 设置多个key-value
        jedis.mset("k1", "v1", "k2", "v2", "k3", "v3");
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    // 操作key List类型
    @Test
    public void useList() {
        // 创建Jedis对象
        Jedis jedis = new Jedis("192.168.229.129", 6379);

        jedis.lpush("username", "zhangsan", "lisi", "wangwu", "zhaoliu");
        List<String> values = jedis.lrange("username", 0, -1);
        System.out.println(values);
    }

    // 操作key Set类型
    @Test
    public void useSet() {
        // 创建Jedis对象
        Jedis jedis = new Jedis("192.168.229.129", 6379);

        jedis.sadd("setName", "zhangsan", "lisi", "wangwu");
        Set<String> setName = jedis.smembers("setName");
        System.out.println(setName);
    }

    // 操作key Hash类型
    @Test
    public void useHash() {
        // 创建Jedis对象
        Jedis jedis = new Jedis("192.168.229.129", 6379);
        jedis.hset("users", "age", "18");
        String hget = jedis.hget("users", "age");
        System.out.println(hget);
    }

    // 操作key ZSet类型
    @Test
    public void useZSet() {
        // 创建Jedis对象
        Jedis jedis = new Jedis("192.168.229.129", 6379);
        jedis.zadd("china", 100d, "上海");
        Set<String> chain = jedis.zrange("chain", 100, -1);
        System.out.println(chain);
    }
}
