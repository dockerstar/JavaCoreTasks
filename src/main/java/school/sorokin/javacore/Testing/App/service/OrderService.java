package school.sorokin.javacore.Testing.App.service;

import school.sorokin.javacore.Testing.App.Exception.NoSuchOrderException;
import school.sorokin.javacore.Testing.App.model.Order;
import school.sorokin.javacore.Testing.App.repository.OrderRepository;

import java.util.Optional;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String processOrder(Order order) {
        if (order!=null) {
            orderRepository.saveOrder(order);
            return  "Order processed successfully";
        } else throw new NoSuchOrderException("Order processing failed");
    }

    public double calculateTotal(int id) {
        Optional<Order> order = orderRepository.getOrderById(id);
        if (order.isPresent()) {
            return order.map(Order::getTotalPrice).get();
        } else throw new NoSuchOrderException("Order not found");
    }
}
