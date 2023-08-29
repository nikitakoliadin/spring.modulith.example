package com.qthegamep.spring.modulith.example;

import com.qthegamep.spring.modulith.example.order.Order;
import com.qthegamep.spring.modulith.example.order.OrderManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);

        // Simulation
        configurableApplicationContext.getBean(OrderManagement.class).complete(new Order());
    }
}
