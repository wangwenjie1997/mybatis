package com.wwj.mybatis.controller;

import com.wwj.mybatis.entity.User;
import com.wwj.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 一对多查询
     * localhost:8080/selectuser?id=1
     */
    @RequestMapping("selectuser")
    public User selectUser(int id){
        return userService.selectUser(id);
    }

}
