package com.moulik.rabbitMq_Demo.Controller;

import com.moulik.rabbitMq_Demo.Dto.User;
import com.moulik.rabbitMq_Demo.Publisher.RabbitMqJsonProducer;
import com.moulik.rabbitMq_Demo.Publisher.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Api")
public class RabbitmqController {
    @Autowired
    RabbitMqProducer RP;
    @GetMapping("/publish")
    public ResponseEntity<String> getmessage(@RequestParam("message") String message){
        RP.sendmessage(message);
        return new ResponseEntity<>("Response Send to RabbitMq", HttpStatus.ACCEPTED);
    }
    @Autowired
    RabbitMqJsonProducer RJP;
    @PostMapping("/publish")
    public ResponseEntity<String> getJsonmsg(@RequestBody User user){
        RJP.sendJsonMessage(user);
        return new ResponseEntity<>("Json Message is Send To RabbitMQ",HttpStatus.ACCEPTED);
    }
}