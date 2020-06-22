package com.fufeng.dream.controller;

import com.fufeng.dream.domain.Book;
import com.fufeng.dream.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: Java-group
 * @description: 书籍控制类
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-22 09:37
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public List<Book> getBookList(){
        return bookService.getBookList();
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public boolean saveItem(Book book){
        return bookService.saveBook(book);
    }

}
