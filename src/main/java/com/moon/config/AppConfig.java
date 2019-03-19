package com.moon.config;

import com.moon.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public User initUser(){
        User user = new User();
        user.setId(1);
        user.setUserName("user_name_1");
//        user.setNote("note_1");
        return user;
    }
}
