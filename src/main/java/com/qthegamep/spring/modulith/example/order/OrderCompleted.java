package com.qthegamep.spring.modulith.example.order;

import org.jmolecules.event.types.DomainEvent;

public record OrderCompleted(Order.OrderIdentifier orderId) implements DomainEvent {
}
