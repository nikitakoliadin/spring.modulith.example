package com.qthegamep.spring.modulith.example.order;

import lombok.RequiredArgsConstructor;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

@ApplicationModuleTest
@RequiredArgsConstructor
public class OrderIntegrationTests {

    OrderManagement orders;

    @Test
    void publishesOrderCompletion(Scenario scenario) {
        var order = new Order();

        scenario.stimulate(() -> orders.complete(order))
                .andWaitForEventOfType(OrderCompleted.class)
                .matchingMappedValue(OrderCompleted::orderId, order.getId())
                .toArrive();
    }
}
