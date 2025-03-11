package com.od.receiver.listener;

import com.od.receiver.rabitmq.model.SimpleMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
  @RabbitListener(queues = "od.rabbit.queue")
  public void receiveMessage(final SimpleMessage message) {
    System.out.println("Receiver listener got message: " + message.getContent());
  }
}
