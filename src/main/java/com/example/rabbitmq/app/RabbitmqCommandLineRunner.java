package com.example.rabbitmq.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Nicholas Drone on 9/28/17.
 */
public class RabbitmqCommandLineRunner implements CommandLineRunner
{
    private static final Logger log = LoggerFactory.getLogger(RabbitmqCommandLineRunner.class);

    private final ConfigurableApplicationContext context;

    @Value("${tutorial.client.duration:0}")
    private int duration;

    public RabbitmqCommandLineRunner(ConfigurableApplicationContext context)
    {
        this.context = context;
    }

    @Override
    public void run(String... strings) throws Exception
    {
        log.info("Ready ... running for {} ms", duration);
        Thread.sleep(duration);
        context.close();
    }
}
