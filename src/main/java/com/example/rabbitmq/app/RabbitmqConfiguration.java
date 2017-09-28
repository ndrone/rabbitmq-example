package com.example.rabbitmq.app;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Nicholas Drone on 9/28/17.
 */
@Configuration
public class RabbitmqConfiguration
{
    @Bean
    public Queue queue()
    {
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean
    public Receiver receiver()
    {
        return new Receiver();
    }

    @Profile("sender")
    @Bean
    public Sender sender(RabbitTemplate rabbitTemplate, Queue queue)
    {
        return new Sender(rabbitTemplate, queue);
    }

    @Profile("sender")
    @Bean
    public CommandLineRunner commandLineRunner(ConfigurableApplicationContext context)
    {
        return new RabbitmqCommandLineRunner(context);
    }
}
