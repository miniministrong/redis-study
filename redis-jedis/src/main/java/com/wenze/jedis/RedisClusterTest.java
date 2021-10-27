package com.wenze.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * Redis集群操作
 */
public class RedisClusterTest {
    public static void main(String[] args) {
        // 创建对象
        HostAndPort hostAndPort = new HostAndPort("192.168.229.129", 6379);
        JedisCluster jedisCluster = new JedisCluster(hostAndPort);
        // 进行操作
        jedisCluster.set("b2", "value2");
        String value = jedisCluster.get("b2");
        System.out.println("value = " + value);
        jedisCluster.close();
    }
}
