package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.config.ConstantProperties;
import com.example.enums.HttpStatusEnum;
import com.example.pojo.generate.Title;
import com.example.service.LoginService;
import com.example.util.RespUtil;
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

    @Autowired
    private ConstantProperties constantProperties;

    @ApiOperation(
            value = "mybatis测试",
            notes = "测试",
            response = String.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int")})
    @GetMapping("/test")
    public RespUtil login(@RequestParam(value = "id", defaultValue = "0") int id) {
        Title title = loginService.getUserById(id);
        if (title == null) {
            return new RespUtil(HttpStatusEnum.FAIL, "");
        }
        String data = title.getTitleName() + " :" + title.getId();
        JSONObject json = new JSONObject();
        json.put("res", data);
        json.put("test", constantProperties.getTestName());
        return new RespUtil(HttpStatusEnum.SUCCESS, json);
    }

    @GetMapping("/redis")
    public RespUtil getUser() {
        Title title = new Title();
        title.setId(1);
        title.setTitleName("小龙人");
        title.setDescribes("123123");
        Object uid = redisTemplate.opsForValue().get("uid");
        if (uid != null) {
            System.out.println(uid.toString());
        }
        JSONObject json = new JSONObject();
        json.put("res", title);
        return new RespUtil(HttpStatusEnum.SUCCESS, json);
    }

    @GetMapping("/redis_res")
    public RespUtil uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        redisTemplate.opsForValue().set("uid", uid);
        JSONObject json = new JSONObject();
        json.put("res", session.getId());
        return new RespUtil(HttpStatusEnum.SUCCESS, json);
    }


    @GetMapping("/rabbit")
    public String rabbitTest() {
        rabbitTemplate.convertAndSend("test", "this is a test context");
        return "OK";
    }
}
