package com.wwj.mybatis.mapper;

import java.util.List;

import com.wwj.mybatis.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="id",property="books",javaType=List.class
                    ,many=@Many(select="com.wwj.mybatis.mapper.BookMapper.getBooksByUserId"))
//		column="id"的id为数据库User表的id字段,把User表id字段的值传给selectBookById()方法,property="books"的book为User类的List<Book>名称
    })
    User selectUser(int id);

    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name")
    })
    User selectUserTwo(int id);

}
