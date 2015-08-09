package com.sm.service;

import com.sm.domain.Message;

import java.util.List;

/**
 * @author Sergii Makarenko
 */
public interface MessageService {
    Long saveMessage(String phone, String msg);
    List<Message> findAllMessage();
}
