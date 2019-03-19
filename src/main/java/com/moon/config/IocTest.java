package com.moon.config;

import com.moon.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class IocTest {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
            User user = ctx.getBean(User.class);
        log.info("{}",user.getId());
    }

}
