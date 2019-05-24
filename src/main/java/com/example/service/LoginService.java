package com.example.service;

import com.example.dao.generate.TitleMapper;
import com.example.pojo.generate.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private TitleMapper titleMapper;

    public Title getUserById(int id){
        return titleMapper.selectByPrimaryKey(id);
    }
}
