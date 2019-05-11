package com.example.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            public Object generate(Object target, Method method, Object... params){
                StringBuilder sb  = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for(Object obj : params){
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        //创建一个模板类
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        //将刚才的redis连接工厂设置到模板类中
        template.setConnectionFactory(factory);
        return template;
    }

}
