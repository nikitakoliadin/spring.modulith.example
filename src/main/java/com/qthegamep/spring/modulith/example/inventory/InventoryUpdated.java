package com.qthegamep.spring.modulith.example.inventory;

import com.qthegamep.spring.modulith.example.order.Order;

public record InventoryUpdated(Order.OrderIdentifier orderId) {
}
