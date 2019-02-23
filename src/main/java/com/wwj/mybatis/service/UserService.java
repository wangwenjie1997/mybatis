package com.wwj.mybatis.service;

import com.wwj.mybatis.entity.User;
import com.wwj.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectUser(int id){
        return userMapper.selectUser(id);
    }

}
