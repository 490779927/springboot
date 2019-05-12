package com.example.controller;

import com.example.pojo.generate.AuthUser;
import com.example.service.LoginService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class TestController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public String login(){
        AuthUser authUser = loginService.LoginStatus();
        if (authUser == null) {
            return "OK";
        }
        return authUser.getAuthUserName();
    }

    @GetMapping("/redis")
    public AuthUser getUser(){
        AuthUser authUser = new AuthUser();
        authUser.setAuthUserId(1);
        authUser.setAuthUserName("杨进");
        authUser.setAuthUserPwd("123123");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        Object uid = redisTemplate.opsForValue().get("uid");
        if(uid!=null){
            System.out.println(uid.toString());
        }
        return authUser;
    }

    @GetMapping("/redis_res")
    public String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if(uid == null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        redisTemplate.opsForValue().set("uid",uid);
        return session.getId();
    }

    @GetMapping("/rabbit")
    public String rabbitTest(){
        rabbitTemplate.convertAndSend("test","this is a test context");
        return "OK";
    }
}
