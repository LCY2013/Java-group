package com.fufeng.dream.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @program: Java-group
 * @description: 书籍实体类
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-19 17:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("book")
public class Book extends Model<Book> {

    private int id;

    private String name;

    private int count;

}
