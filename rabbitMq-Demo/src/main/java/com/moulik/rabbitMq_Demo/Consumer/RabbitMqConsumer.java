package com.moulik.rabbitMq_Demo.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqConsumer {
    private static final Logger logger= LoggerFactory.getLogger(RabbitMqConsumer.class);
    @RabbitListener(queues = "${queue.name}")
    public void getMsg(String message){
        logger.info(String.format("Massage Recive is -> %s",message));
    }
}
