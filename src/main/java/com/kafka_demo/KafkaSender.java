package com.kafka_demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息发送者
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void send(String content) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(content);
        message.setSendTime(new Date());
        kafkaTemplate.send("zzzz", message.toString());
    }
}