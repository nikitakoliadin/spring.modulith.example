package com.qthegamep.spring.modulith.example;

import com.qthegamep.spring.modulith.example.order.Order;
import com.qthegamep.spring.modulith.example.order.OrderManagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan
public class Application {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);

        log.info("Simulation started");

        configurableApplicationContext.getBean(OrderManagement.class).complete(new Order());

        log.info("Simulation finished");
    }
}
