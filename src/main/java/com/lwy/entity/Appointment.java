package com.lwy.entity;

import java.util.Date;

public class Appointment {
    private long book_id;
    private long student_id;
    private Date appointment; //预约的时间

    //一对多的复合属性--一本书可以被多次预约;
    private Book book;

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Appointment() {
    }

    public Appointment(long book_id, long student_id, Date appointment, Book book) {
        this.book_id = book_id;
        this.student_id = student_id;
        this.appointment = appointment;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "book_id=" + book_id +
                ", student_id=" + student_id +
                ", appointment=" + appointment +
                ", book=" + book +
                '}';
    }
}
