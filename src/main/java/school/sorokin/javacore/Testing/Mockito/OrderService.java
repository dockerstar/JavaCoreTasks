package school.sorokin.javacore.Testing.Mockito;

import school.sorokin.javacore.Testing.Mockito.Exception.NoPayException;
import school.sorokin.javacore.Testing.Mockito.Pay.PaymentService;

public class OrderService {
    private final NotificationService notificationService;
    private final PaymentService paymentService;
    private final OrderRepository orderRepository;

    public OrderService(NotificationService notificationService, PaymentService paymentService,
                 OrderRepository orderRepository) {
        this.notificationService=notificationService;
        this.paymentService=paymentService;
        this.orderRepository=orderRepository;
    }

    public Order createOrder(String title, boolean statusPay){
        if (statusPay) {
            Order order = orderRepository.save(title);
            order.setStatusPay(statusPay);
            order.setTypePay(paymentService.pay());
            order.setToSend(notificationService.send());
            return order;
        } else throw new NoPayException("Не оплатил чепуха");
    }

    public Order getOrder(int id) {
        return orderRepository.get(id);
    }

}
