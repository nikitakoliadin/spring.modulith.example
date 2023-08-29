package com.qthegamep.spring.modulith.example.order;

import lombok.Getter;
import lombok.ToString;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;

@Getter
@ToString
public class Order implements AggregateRoot<Order, Order.OrderIdentifier> {

    private final OrderIdentifier id = new OrderIdentifier(UUID.randomUUID());

    public record OrderIdentifier(UUID id) implements Identifier {
    }
}
