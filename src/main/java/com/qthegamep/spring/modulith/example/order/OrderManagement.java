package com.qthegamep.spring.modulith.example.order;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderManagement {

    @NonNull
    private final ApplicationEventPublisher events;

    @Transactional
    public void complete(Order order) throws InterruptedException {
        log.info("New order: {}", order);

        // Simulate busy work
        Thread.sleep(3000);

        OrderCompleted orderCompleted = new OrderCompleted(order.getId());
        events.publishEvent(orderCompleted);

        log.info("Order completed: {}", orderCompleted);
    }
}
