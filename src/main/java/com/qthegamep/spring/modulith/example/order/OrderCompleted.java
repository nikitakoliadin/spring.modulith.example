package com.qthegamep.spring.modulith.example.order;

import org.jmolecules.event.types.DomainEvent;

import java.util.UUID;

public record OrderCompleted(UUID orderId) implements DomainEvent {
}
