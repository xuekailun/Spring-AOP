package com.moon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    /**
     * <h2>配置 RedisTemplate key/value 的序列化方式</h2>
     * */
    @Bean("RedisTemplate")
    RedisTemplate getRedisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // RedisTemplate key/value 默认的序列化策略
        JdkSerializationRedisSerializer redisSerializer = new JdkSerializationRedisSerializer();

        // StringRedisTemplate key/value 默认的序列化策略
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();

        template.setConnectionFactory(factory);
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(redisSerializer);

        return template;
    }
}
