package com.lwy.dao;

import com.lwy.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    /**
     * 通过id查找方法
     * @param bookId
     * @return
     */
    Book queryById(long bookId);

    /**
     * 通过 offset 和limit查找一个范围的数据
     * @param offset
     * @param limit
     * @return
     */
    /*在mybatis中,如果方法中的参数超过了1,需要加注解@param*/
    List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * 通过id删除这本书
     * @param bookId
     * @return
     */
    int reduceNumber(long bookId);
}
