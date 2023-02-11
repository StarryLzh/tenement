package com.renthouse.cache.config;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 定义一个抽象父类，用于提供模板配置
 * 用于
 * * 连接redis服务器
 * * 提供返回 redisTemplate方法，来操作redis
 */
public class RedisCacheConfiguration {

    //参数是：连接工厂对象
    protected RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //key是String，用String序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //value就用Object序列化器 把value转为json
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }
}
