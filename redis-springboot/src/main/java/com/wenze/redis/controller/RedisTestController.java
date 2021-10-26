package com.wenze.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/demo")
    public String testRedis() {
        // 设置值到Redis中
        redisTemplate.opsForValue().set("name", "zhangsan");
        // 从Redis获取值
        return (String) redisTemplate.opsForValue().get("name");
    }
}
