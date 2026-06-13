package school.sorokin.javacore.Testing.App.repository;

import school.sorokin.javacore.Testing.App.model.Order;

import java.util.Optional;

public interface OrderRepository {
    int saveOrder(Order order);
    Optional<Order> getOrderById(int id);
}
