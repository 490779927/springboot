package com.example.service;

import com.example.dao.self.TitleSelfMapper;
import com.example.pojo.generate.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private TitleSelfMapper titleSelfMapper;

    public Title getUserById(int id) {
        return titleSelfMapper.selectByPrimaryKey(id);
    }

    public List<Title> getAllUserInfo() {
        return titleSelfMapper.getAllUserInfo();
    }
}
