package com.sm.dao;

import com.sm.domain.Message;

import java.util.List;

/**
 * @author Sergii Makarenko
 * interface for Messages
 */
public interface MessageDao {
    Long saveMessage(String phone, String msg);
    List<Message> findAllMessage();
}
