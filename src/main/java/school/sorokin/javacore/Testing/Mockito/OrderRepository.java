package school.sorokin.javacore.Testing.Mockito;

import school.sorokin.javacore.Testing.Mockito.Pay.PaymentService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderRepository {
    Map<Integer, Order> orderMap = new HashMap<>();
    int count = 0;
    Logger logger = Logger.getLogger(OrderRepository.class.getName());

    public Order save(String title) {
        Order order = new Order(count, title);
        orderMap.put(count, order);
        logger.log(Level.INFO, "Создан заказ");
        return order;
    }

    public Order get(int id) {
        Order order = orderMap.get(id);
        return order;
    }
}
