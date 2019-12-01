package com.lwy.services.impl;

import com.lwy.Enum.AppointmentStateEnum;
import com.lwy.dao.AppointmentMapper;
import com.lwy.dao.BookMapper;
import com.lwy.dlt.AppointExecution;
import com.lwy.entity.Appointment;
import com.lwy.entity.Book;
import com.lwy.exception.AppointException;
import com.lwy.exception.NoNumberException;
import com.lwy.exception.RepeatAppointException;
import com.lwy.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public Book getById(long bookId) {
        return bookMapper.queryById(bookId);
    }

    @Override
    public List<Book> getAll(int offset, int limit) {
        return bookMapper.queryAll(offset,limit);
    }

    @Override
    //真正的去实行一个预约的操作,但是不能够直接操作,先判断还有没有库存.如果有库存才可以执行预约,这时候执行
    //appointment的insertAppointment方法
    public AppointExecution appoint(long bookId, long studentId) {

        int reduceNumber = bookMapper.reduceNumber(bookId);
        try{
            if (reduceNumber<=0){
                throw new NoNumberException("没有库存了!");
            }else {
                //因为有主键的限制
                int appointment = appointmentMapper.insertAppointment(bookId, studentId);
                System.out.println();
                if (appointment <= 0) {
                    throw new RepeatAppointException("重复预约");
                } else {
                    System.out.println("++++lala");
                    Appointment appointment1 = appointmentMapper.queryByKeyWithBook(bookId, studentId);
                    System.out.println(appointment1);
                    return new AppointExecution(bookId, AppointmentStateEnum.SUCCESS, appointment1);

                }
            }
                // 要先于catch Exception异常前先catch住再抛出，不然自定义的异常也会被转换为AppointException，导致控制层无法具体识别是哪个异常
        } catch (NoNumberException e1) {
            throw e1;
        } catch (RepeatAppointException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            //return new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);//错误写法
            throw new AppointException("appoint inner error:" + e.getMessage());
        }


    }
}
