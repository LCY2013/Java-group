package com.fufeng.dream.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fufeng.dream.domain.Book;
import com.fufeng.dream.mapper.BookMapper;
import com.fufeng.dream.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Java-group
 * @description: 书籍具体实现类
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-22 09:39
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    /**
     * 获取书籍列表
     * @return 书籍列表
     */
    @Override
    public List<Book> getBookList() {
        return baseMapper.selectList(Wrappers.lambdaQuery());
    }

    /**
     *  保存书籍信息
     * @param book 书籍信息
     * @return 返回受影响的行数
     */
    @Override
    public Boolean saveBook(Book book) {
        return super.save(book);
    }

}
