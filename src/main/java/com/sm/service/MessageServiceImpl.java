package com.sm.service;

import com.sm.dao.MessageDao;
import com.sm.dao.MessageDaoImpl;
import com.sm.domain.Message;

import java.util.List;

/**
 * @author Sergii Makarenko
 */
public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao;

    public MessageServiceImpl(MessageDaoImpl messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public Long saveMessage(String phone, String msg) {
        return messageDao.saveMessage(phone, msg);
    }

    @Override
    public List<Message> findAllMessage() {
        return messageDao.findAllMessage();
    }
}
