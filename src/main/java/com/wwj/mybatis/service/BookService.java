package com.wwj.mybatis.service;

import com.wwj.mybatis.entity.Book;
import com.wwj.mybatis.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public int insertBook(Book book){
        return bookMapper.insertBook(book);
    }

    public Book selectBook(int id){
        return bookMapper.selectBookById(id);
    }

    public List<Book> fuzzyQueryBook(String name){
        return bookMapper.fuzzyQueryBook(name);
    }

    public int deleteBook(int id){
        return bookMapper.deleteBook(id);
    }

    public int updateBook(Book book){
        return bookMapper.updateBook(book);
    }

    public Book selectBookTwo(int id){
        return bookMapper.selectBookTwo(id);
    }

}
