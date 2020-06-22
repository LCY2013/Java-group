package com.fufeng.dream.service;

import com.fufeng.dream.domain.Book;

import java.util.List;

/**
 * @program: Java-group
 * @description: book 接口定义
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-22 09:38
 */
public interface BookService {

    /**
     * 获取书籍列表
     * @return 书籍列表
     */
    List<Book> getBookList();

    /**
     *  保存书籍信息
     * @param book 书籍信息
     * @return 返回受影响的行数
     */
    Boolean saveBook(Book book);

}
