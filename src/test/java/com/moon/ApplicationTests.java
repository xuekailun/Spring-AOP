package com.moon;

import com.alibaba.fastjson.JSON;
import com.moon.intercept.MyInterceptor;
import com.moon.pojo.ProxyBean;
import com.moon.pojo.User;
import com.moon.serivce.HelloService;
import com.moon.serivce.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private HelloService helloService;


    @Test
    public void testProxy() {
        HelloService helloService = new HelloServiceImpl();
        // 按约定获取 proxy
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService,new MyInterceptor());

        proxy.sayHello("张三");
        System.out.println("\n#######################name is null!!##########\n");
        proxy.sayHello(null);
    }


    @Test
    public void contextLoads() {

        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();

        User user =new User();
        user.setId(10);
        user.setUserName("miss");
//        user.setNote("note");
        valueOperations.set("user",JSON.toJSONString(user));

        log.info("User : {}",JSON.parseObject(valueOperations.get("user")));
        Map map = new HashMap();
        user =  JSON.parseObject(valueOperations.get("user"),User.class);
    }


    @Test
    public void getCollection(){
//        List<Integer> integers = Arrays.asList(2,3,1,6,7,9);
//        Collections.sort(integers);
//        log.info("正序{}",integers);
//        Collections.reverse(integers);
//        log.info("倒叙{}",integers);
        User user2 = new User(2,"张三2",2);
        User user3 = new User(3,"张三3",1);
        User user1 = new User(1,"张三1",3);


        List<User> users = Arrays.asList(user1,user2,user3);

//        users.sort(Comparator.comparing(User::getUserName));

//        Collections.reverse(users);

        Collections.sort(users,Comparator.comparing(User::getNote));
        log.info("正常顺序：{}",users);
    }
}
