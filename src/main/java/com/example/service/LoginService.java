package com.example.service;

import com.example.dao.generate.AuthUserMapper;
import com.example.pojo.generate.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthUserMapper authUserMapper;

    public AuthUser LoginStatus(){
        AuthUser authUser = authUserMapper.selectOne();
        return authUser;
    }
}
