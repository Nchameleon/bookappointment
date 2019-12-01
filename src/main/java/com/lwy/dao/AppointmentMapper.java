package com.lwy.dao;

import com.lwy.entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentMapper {
    /**
     * 插入一条数据记录
     * @param bookId
     * @param studentId
     * @return
     */
    //这里的bookId和book_id不一样是因为在mybatis中配置了驼峰命名
    int insertAppointment(@Param("bookId") long bookId,@Param("studentId") long studentId);

    /**
     * 通过主键查找到一门预约的记录
     * @param bookId
     * @param studentId
     * @return
     */
    Appointment queryByKeyWithBook(@Param("bookId") long bookId,@Param("studentId") long studentId);
}
