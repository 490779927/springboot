package com.example.dao.generate;

import com.example.pojo.generate.AuthUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AuthUserMapper {
    int deleteByPrimaryKey(Integer authUserId);

    int insert(AuthUser record);

    int insertSelective(AuthUser record);

    AuthUser selectByPrimaryKey(Integer authUserId);

    @Select("select * from auth_user where auth_user_id = 1")
    @Results({
            @Result(property = "authUserName", column = "auth_user_name")
    })
    AuthUser selectOne();

    int updateByPrimaryKeySelective(AuthUser record);

    int updateByPrimaryKeyWithBLOBs(AuthUser record);
}