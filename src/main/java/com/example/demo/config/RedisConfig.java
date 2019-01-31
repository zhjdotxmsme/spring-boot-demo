package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

/**
 * @author hongjin.zhu
 * @description
 * @date 2019年01月04日 11:43
 * @modified By
 */
@Configuration
public class RedisConfig {

    public RedisHttpSessionConfiguration redisHttpSessionConfiguration(){
        RedisHttpSessionConfiguration redisHttpSessionConfiguration = new RedisHttpSessionConfiguration();
        redisHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(600);
        return redisHttpSessionConfiguration;
    }


}
