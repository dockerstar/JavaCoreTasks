package school.sorokin.javacore.Testing.App.repository;

import school.sorokin.javacore.Testing.App.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryOrderRepository implements OrderRepository{
    Map<Integer, Order> orderMap = new HashMap<>();
    Integer count = 0;

    @Override
    public int saveOrder(Order order) {
        orderMap.put(count, order);
        count++;
        return order.getId();
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return Optional.ofNullable(orderMap.get(id));
    }
}
