package com.lwy.services;

import com.lwy.dlt.AppointExecution;
import com.lwy.entity.Book;

import java.util.List;

/**
 * dao层是在底层直接与数据库打交道的,在这里的service层是实现前段的业务逻辑.方法其实和dao的方法一样
 */
public interface BookService {
    /**
     * 查询一本图书
     *
     * @param bookId
     * @return
     */
    Book getById(long bookId);

    /**
     * 查询所有图书
     *
     * @return
     */
    List<Book> getAll(int offset,int limit );

    /**
     * 预约图书
     *
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(long bookId, long studentId);

}
