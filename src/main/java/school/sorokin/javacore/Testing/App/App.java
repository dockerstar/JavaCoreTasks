package school.sorokin.javacore.Testing.App;

import school.sorokin.javacore.Testing.App.Exception.NoSuchOrderException;
import school.sorokin.javacore.Testing.App.model.Order;
import school.sorokin.javacore.Testing.App.repository.InMemoryOrderRepository;
import school.sorokin.javacore.Testing.App.repository.OrderRepository;
import school.sorokin.javacore.Testing.App.service.OrderService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class.getName());
        try {
            Order order = new Order(0 ,"order", -1, 30.0);
            OrderRepository orderRepository = new InMemoryOrderRepository();
            OrderService orderService = new OrderService(orderRepository);
            System.out.println(orderService.processOrder(order));
            System.out.println(orderService.calculateTotal(1));
        } catch (NoSuchOrderException | IllegalArgumentException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }
}
