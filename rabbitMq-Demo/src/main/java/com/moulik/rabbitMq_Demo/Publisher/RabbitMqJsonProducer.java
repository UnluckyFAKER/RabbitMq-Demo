package com.moulik.rabbitMq_Demo.Publisher;

import com.moulik.rabbitMq_Demo.Dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonProducer {
    @Value("${exchange.name}")
    private String exchange;
    @Value("${key.json.name}")
    private String jkey;
    private RabbitTemplate rabbitTemplate;
    public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate) {

        this.rabbitTemplate = rabbitTemplate;
    }
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqJsonProducer.class);
    public void sendJsonMessage(User user){
        logger.info(String.format("The Message is ->%s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,jkey,user);
    }
}
