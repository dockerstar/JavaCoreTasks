import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import school.sorokin.javacore.Testing.App.Exception.NoSuchOrderException;
import school.sorokin.javacore.Testing.App.model.Order;
import school.sorokin.javacore.Testing.App.repository.InMemoryOrderRepository;
import school.sorokin.javacore.Testing.App.repository.OrderRepository;
import school.sorokin.javacore.Testing.App.service.OrderService;

import java.util.Optional;

public class AppOrderServiceTest {
    private OrderRepository orderRepository;
    private OrderService orderService;
    private Order order;

    @BeforeAll
    static void start() {
        System.out.println("Начало теста");
    }

    @BeforeEach
    void init() {
        orderRepository = Mockito.mock(InMemoryOrderRepository.class);
        orderService = new OrderService(orderRepository);
        order = new Order(0 ,"order", 20, 30.0);
    }

    @Test
    void VerificationAndCorrectProcessOrderTest() {
        Mockito.when(orderRepository.saveOrder(order)).thenReturn(0);
        String currOrder = orderService.processOrder(order);
        Assertions.assertEquals("Order processed successfully", currOrder);
        Mockito.verify(orderRepository, Mockito.times(1)).saveOrder(order);
    }

    @Test
    void FailedProcessOrderTest() {
        NoSuchOrderException exception = Assertions.assertThrows(NoSuchOrderException.class, ()-> orderService.processOrder(null));
        Assertions.assertEquals("Order processing failed", exception.getMessage());
        Mockito.verify(orderRepository, Mockito.never()).saveOrder(Mockito.any(Order.class));
    }

    @Test
    void totalCalculatingAnOrderTest() {
        Mockito.when(orderRepository.getOrderById(0)).thenReturn(Optional.ofNullable(order));
        double total = orderService.calculateTotal(0);
        Assertions.assertEquals(600.0, total);
        Mockito.verify(orderRepository, Mockito.times(1)).getOrderById(0);
    }

    @Test
    void orderNotFoundTest() {
        Mockito.when(orderRepository.getOrderById(1)).thenReturn(Optional.empty());
        NoSuchOrderException exception = Assertions.assertThrows(NoSuchOrderException.class, ()-> orderService.calculateTotal(1));
        Assertions.assertEquals("Order not found", exception.getMessage());
        Mockito.verify(orderRepository, Mockito.times(1)).getOrderById(1);
    }

    @Test
    void calculatingInZeroForOrderTest() {
        int quantity = 0;
        double price = 0.0;

        Order order1 = new Order(1, "order", quantity, price);
        double finalPrice = order1.getTotalPrice();
        Assertions.assertEquals(0.0, finalPrice);
    }


}
