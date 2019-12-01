package com.lwy.test;

import com.lwy.dao.BookMapper;
import com.lwy.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Booktest extends BaseTest{

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testQueryById() {
        long bookId = 1003l;
        Book book = bookMapper.queryById(bookId);
        System.out.println(book);

    }
    @Test
    public void testQueryAll(){
        int offset = 1;
        int limit = 3;
        List<Book> list = bookMapper.queryAll(offset,limit);
        for (Book book: list        ) {
            System.out.println(book);
        }
    }
    @Test
    public void testReduceNumber(){
        long bookId = 1001l;
        int i = bookMapper.reduceNumber(bookId);
        System.out.println(i);
    }
}
