package com.qthegamep.spring.modulith.example.inventory;

import com.qthegamep.spring.modulith.example.order.OrderCompleted;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryManagement {

    @NonNull
    private final ApplicationEventPublisher events;

    @ApplicationModuleListener
    void on(OrderCompleted orderCompleted) throws InterruptedException {
        log.info("Received async event new order for completion: {}", orderCompleted);

        // Simulate busy work
        Thread.sleep(3000);

        var inventoryUpdated = new InventoryUpdated(orderCompleted.orderId());
        events.publishEvent(inventoryUpdated);

        log.info("Inventory updated: {}", inventoryUpdated);
    }
}
