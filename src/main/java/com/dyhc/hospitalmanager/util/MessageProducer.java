package com.dyhc.hospitalmanager.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
/**
 * 消息生产者类，生产消息
 */
public class MessageProducer {
    @Autowired
    private JmsTemplate jmsTemplate;
    /**
     * 创建消息生产者
     * @param destination 消息队列地址
     * @param message   消息
     */
    public void sendMessage(Destination destination, Object message){
        this.jmsTemplate.convertAndSend(destination, message);
    }
}
