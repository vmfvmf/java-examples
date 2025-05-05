package com.vmfvmf.ioc.aspect;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void placeOrder(String item, int quantity) {
        System.out.println("Placing order: " + quantity + " x " + item);
    }

    public void cancelOrder(String orderId) {
        System.out.println("Cancelling order: " + orderId);
    }
}
