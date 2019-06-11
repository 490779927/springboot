package com.example.dao.self;

import com.example.dao.generate.TitleMapper;
import com.example.pojo.generate.Title;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleSelfMapper extends TitleMapper {

    @Select({
            "select",
            "id, title_name, describes, del_flag, create_time, update_time",
            "from title"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="title_name", property="titleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="describes", property="describes", jdbcType=JdbcType.VARCHAR),
            @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Title> getAllUserInfo();
}