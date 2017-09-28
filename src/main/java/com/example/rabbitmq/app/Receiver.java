package com.example.rabbitmq.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.concurrent.CompletableFuture;

/**
 * @author Nicholas Drone on 9/28/17.
 */
@RabbitListener(queues = "hello")
public class Receiver
{
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void receive(String message)
    {
        log.info("Received message: {}", message);
        CompletableFuture.runAsync(() -> doWork(message));
    }

    private void doWork(String message)
    {
        for (int i = 0; i < 3; i++)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                //do nothing
            }
        }
        log.info("Done with message: {}", message);
    }
}
