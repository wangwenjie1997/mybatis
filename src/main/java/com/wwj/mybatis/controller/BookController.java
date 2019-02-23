package com.wwj.mybatis.controller;

import com.wwj.mybatis.entity.Book;
import com.wwj.mybatis.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     *插入操作
     * localhost:8080/insertbook?name=book1
     */
    @RequestMapping("insertbook")
    public String insertBook(String name){
        Book book=new Book();
        book.setName(name);
        int result=bookService.insertBook(book);
        return "返回执行数:"+result+"返回插入主键:"+book.getId();
    }

    /**
     * 查询操作
     * localhost:8080/selectbook?id=1
     */
    @RequestMapping("selectbook")
    public Book selectBook(int id){
        return bookService.selectBook(id);
    }

    /**
     * 模糊查询
     * localhost:8080/fuzzyquerybook?name=book1
     */
    @RequestMapping("fuzzyquerybook")
    public List<Book> fuzzyQueryBook(String name){
        return bookService.fuzzyQueryBook(name);
    }

    /**
     * 删除操作
     * localhost:8080/deletebook?id=1
     */
    @RequestMapping("deletebook")
    public String deleteBook(int id){
        int result=bookService.deleteBook(id);
        if(result==1)
            return "删除成功";
        else
            return "删除失败";
    }

    /**
     * 修改操作
     * localhost:8080/editbook?id=1&name=1
     */
    @RequestMapping("editbook")
    public String editBook(int id,String name){
        Book book=new Book();
        book.setId(id);
        book.setName(name);
        int result=bookService.updateBook(book);
        if(result==1)
            return "修改成功";
        else
            return "修改失败";
    }

    /**
     * 一对一查询
     * localhost:8080/selectbooktwo?id=1
     */
    @RequestMapping("selectbooktwo")
    public Book selectBookTwo(int id){
        return bookService.selectBookTwo(id);
    }

}
