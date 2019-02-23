package com.wwj.mybatis.mapper;

import com.wwj.mybatis.entity.Book;
import com.wwj.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    @Insert("insert into book (name) values (#{name})")
    //获取主键方法一
//    @Options(keyColumn="id",keyProperty="id",useGeneratedKeys=true)
    //获取主键方法二
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insertBook(Book book);

    @Select("select * from book where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name")
    })
    Book selectBookById(int id);

    @Select("select * from book where name like concat(concat('%',#{name}),'%')")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name")
    })
    List<Book> fuzzyQueryBook(String name);

    @Delete("delete from book where id=#{id}")
    int deleteBook(int id);

    @Update("update book set name=#{name} where id=#{id}")
    int updateBook(Book book);

    @Select("select * from book where userId=#{id}")
    List<Book> getBooksByUserId(int id);

    @Select("select * from book where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="userId",property="user",javaType=User.class
                    ,one=@One(select="com.wwj.mybatis.mapper.UserMapper.selectUserTwo"))
//		column="userId"的id为数据库Book表的userId字段,把Book表userId字段的值传给selectUserTwo()方法,property="user"的user为Book类的User名称
    })
    Book selectBookTwo(int id);

}
