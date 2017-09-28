package com.example.rabbitmq.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Nicholas Drone on 9/28/17.
 */
public class Sender
{
    private static final Logger log = LoggerFactory.getLogger(Sender.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    private int counter;

    public Sender(RabbitTemplate rabbitTemplate, Queue queue)
    {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;

        counter = 0;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send()
    {
        counter++;
        String message = "Hello world!" + counter;
        this.rabbitTemplate.convertAndSend(queue.getName(), message);
        log.info("Sent message: {}", message);
    }
}
