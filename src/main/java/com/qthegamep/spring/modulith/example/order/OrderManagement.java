package com.qthegamep.spring.modulith.example.order;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderManagement {

    @NonNull
    private final ApplicationEventPublisher events;

    @Transactional
    public void complete() {
        events.publishEvent(new OrderCompleted(UUID.randomUUID()));
    }
}
