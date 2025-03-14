package com.moulik.rabbitMq_Demo.Publisher;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class RabbitMqProducer {
    @Value("${exchange.name}")
    private String exchange;
    @Value("${key.name}")
    private String key;
    private RabbitTemplate rabbitTemplate;
    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqProducer.class);
    public void sendmessage(String message){
        logger.info(String.format("The Message is ->%s",message));
        rabbitTemplate.convertAndSend(exchange,key,message);
    }
}
