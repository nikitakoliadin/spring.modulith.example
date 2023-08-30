package com.qthegamep.spring.modulith.example;

import com.qthegamep.spring.modulith.example.order.Order;
import com.qthegamep.spring.modulith.example.order.OrderManagement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationIntegrationTests {

    @Autowired
    OrderManagement orders;

    @Test
    void completesOrder() throws Exception {
        orders.complete(new Order());

        Thread.sleep(10000);
    }
}
