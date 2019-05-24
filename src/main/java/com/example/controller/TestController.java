package com.example.controller;

import com.example.pojo.generate.Title;
import com.example.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Api(value = "消息", protocols = "http")
@RestController
public class TestController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ApiOperation(
            value = "mybatis测试",
            notes = "测试",
            response = String.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int")})
    @GetMapping("/test")
    public String login(@RequestParam(value = "id",defaultValue = "0") int id) {
        Title title = loginService.getUserById(id);
        if (title == null) {
            return "OK";
        }
        return title.getTitleName()+" :" +title.getId();
    }

    @GetMapping("/redis")
    public Title getUser() {
        Title title = new Title();
        title.setId(1);
        title.setTitleName("小龙人");
        title.setDescribes("123123");
        Object uid = redisTemplate.opsForValue().get("uid");
        if (uid != null) {
            System.out.println(uid.toString());
        }
        return title;
    }

    @GetMapping("/redis_res")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        redisTemplate.opsForValue().set("uid", uid);
        return session.getId();
    }


    @GetMapping("/rabbit")
    public String rabbitTest() {
        rabbitTemplate.convertAndSend("test", "this is a test context");
        return "OK";
    }
}
