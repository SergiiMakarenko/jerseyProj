package com.sm.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Message entity
 * id - message ID, phoneNumber - number for send message, msg - text, date - date of send
 * @author Sergii Makarenko
 */
@Entity
@Table(name="MESSAGE")
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "MSG")
    private String msg;

    @Column(name = "MSGDATE")
    private Date date;

    public Message(){}

    public Message(String phoneNumber, String msg, Date date) {
        this.phoneNumber = phoneNumber;
        this.msg = msg;
        this.date=date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
