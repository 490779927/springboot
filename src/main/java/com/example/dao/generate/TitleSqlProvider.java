package com.example.dao.generate;

import com.example.pojo.generate.Title;
import org.apache.ibatis.jdbc.SQL;

public class TitleSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table title
     *
     * @mbg.generated
     */
    public String insertSelective(Title record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("title");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitleName() != null) {
            sql.VALUES("title_name", "#{titleName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescribes() != null) {
            sql.VALUES("describes", "#{describes,jdbcType=VARCHAR}");
        }
        
        if (record.getDelFlag() != null) {
            sql.VALUES("del_flag", "#{delFlag,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table title
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(Title record) {
        SQL sql = new SQL();
        sql.UPDATE("title");
        
        if (record.getTitleName() != null) {
            sql.SET("title_name = #{titleName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescribes() != null) {
            sql.SET("describes = #{describes,jdbcType=VARCHAR}");
        }
        
        if (record.getDelFlag() != null) {
            sql.SET("del_flag = #{delFlag,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}