package com.sm.dao;

import com.sm.domain.Message;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
 * @author Sergii Makarenko
 * implementation interface for Messages
 */
public class MessageDaoImpl implements MessageDao  {
    private static final Logger logger = Logger.getLogger(MessageDaoImpl.class);
    private SessionFactory factory;

    public MessageDaoImpl(SessionFactory sessionFactory) {
        this.factory=sessionFactory;
    }

    public Long saveMessage(String phone, String msg) {
        Session session = null;
        Long id = null;
        try{
            logger.info("Start saving message. Parameters: phone = " + phone + ", msg = " + msg);
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(new Message(phone, msg, new Date()));
            session.getTransaction().commit();
            logger.info("Finished save message, id = " +id);
        } catch (HibernateException he){
            System.out.println("Create new message failed ");
            logger.error("Create new message failed ");
        } finally {
            if (session!=null)
                session.close();
        }
        return id;
    }

    @Override
    public List<Message> findAllMessage() {
        Session session = null;
        List<Message> messages = null;
        try{
            logger.info("start finding message...");
            session = factory.openSession();
            session.beginTransaction();
            messages = session.createCriteria(Message.class)
            .list();
            for(Message msg:messages){
                if(msg.getMsg()!=null && msg.getMsg().length()>20){
                    String shortString = msg.getMsg().substring(0,20)+"...";
                    msg.setMsg(shortString);
                }
            }
            session.getTransaction().commit();
            logger.info("... find " + messages.size() + " rows.");
        } catch (HibernateException he){
            System.out.println("Find all messages failed ");
            logger.error("Find all messages failed ");
        } finally {
            if (session!=null)
                session.close();
        }
        return messages;
    }
}
