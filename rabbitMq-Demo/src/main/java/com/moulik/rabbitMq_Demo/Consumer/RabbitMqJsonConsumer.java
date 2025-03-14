package com.moulik.rabbitMq_Demo.Consumer;

import com.moulik.rabbitMq_Demo.Dto.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class RabbitMqJsonConsumer {

        private static final Logger logger= LoggerFactory.getLogger(com.moulik.rabbitMq_Demo.Consumer.RabbitMqConsumer.class);
        @RabbitListener(queues = "${queue.json.name}")
        public void getMsg(User user)
        {
            logger.info(String.format("Massage Json Recive is -> %s",user.toString()));

        }
}
