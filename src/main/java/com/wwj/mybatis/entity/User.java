package com.wwj.mybatis.entity;


import lombok.Data;

import java.util.List;

@Data
public class User {

    private int id;
    private String name;
    private List<Book> books;

}
