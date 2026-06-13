import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import school.sorokin.javacore.Testing.Mockito.Exception.NoPayException;
import school.sorokin.javacore.Testing.Mockito.NotificationService;
import school.sorokin.javacore.Testing.Mockito.Order;
import school.sorokin.javacore.Testing.Mockito.OrderRepository;
import school.sorokin.javacore.Testing.Mockito.OrderService;
import school.sorokin.javacore.Testing.Mockito.Pay.PaymentService;
import school.sorokin.javacore.Testing.Mockito.Pay.SBPPay;

public class OrderServiceTest {
    PaymentService paymentService;
    NotificationService notificationService;
    OrderRepository orderRepository;
    OrderService orderService;

    @BeforeEach
    void setUp() {
        paymentService = Mockito.mock(PaymentService.class);
        notificationService = Mockito.mock(NotificationService.class);
        orderRepository = Mockito.mock(OrderRepository.class);
        orderService = new OrderService(notificationService, paymentService, orderRepository);
    }

    @Test
    void CreateOrderPayTrueAndNotifSendTest() {
        String typePay = "SBP";
        String toSend = "TG";
        Order order = new Order(0, "order");
        Mockito.when(paymentService.pay()).thenReturn(typePay);
        Mockito.when(notificationService.send()).thenReturn(toSend);
        Mockito.when(orderRepository.save("order")).thenReturn(order);
        Order order1 = orderService.createOrder("order", true);
        Assertions.assertEquals(order, order1);
        Mockito.verify(paymentService, Mockito.times(1)).pay();
        Mockito.verify(notificationService, Mockito.times(1)).send();
        Mockito.verify(orderRepository, Mockito.times(1)).save("order");
    }

    @Test
    void CreateOrderNoPayTest() {
        NoPayException exception = Assertions.assertThrows(NoPayException.class, ()->
                orderService.createOrder("order", false));
        Assertions.assertEquals("Не оплатил чепуха", exception.getMessage());
        Mockito.verify(paymentService, Mockito.never()).pay();
        Mockito.verify(notificationService, Mockito.never()).send();
        Mockito.verify(orderRepository, Mockito.never()).save(Mockito.any(String.class));
    }

}
