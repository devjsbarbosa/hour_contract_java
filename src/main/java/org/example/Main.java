package org.example;

import org.example.entities.Order;
import org.example.entities.enums.OrderStatus;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order);


        OrderStatus orderStatus = OrderStatus.DELIVERED;
        OrderStatus orderStatus2 = OrderStatus.valueOf("DELIVERED");
        System.out.println(orderStatus2);
    }


}