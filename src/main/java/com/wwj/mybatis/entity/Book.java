package com.wwj.mybatis.entity;

import lombok.Data;

@Data
public class Book {

    private int id;
    private String name;
    private User user;

}
