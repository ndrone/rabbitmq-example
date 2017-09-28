package com.example.rabbitmq.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author Nicholas Drone on 9/28/17.
 */
@RabbitListener(queues = "hello")
public class Receiver
{
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void receive(String message) throws InterruptedException
    {
        log.info("Received message: {}", message);
        doWork(message);
    }

    private void doWork(String message) throws InterruptedException
    {
        for (int i = 0; i < 3; i++)
        {
            Thread.sleep(1000);
        }
        log.info("Work complete for message: {}", message);
    }
}
