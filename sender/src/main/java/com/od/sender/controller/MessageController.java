package com.od.sender.controller;

import com.od.sender.rabbitmq.model.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
  private final RabbitTemplate rabbitTemplate;

  public MessageController(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @PostMapping("/send")
  public String sendMessage(@RequestBody final SimpleMessage message) {
    rabbitTemplate.convertAndSend("od.rabbit.queue", message);
    return "Message sent!";
  }
}
