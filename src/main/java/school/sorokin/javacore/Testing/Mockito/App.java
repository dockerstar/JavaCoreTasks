package school.sorokin.javacore.Testing.Mockito;

import school.sorokin.javacore.Testing.Mockito.Exception.NoPayException;
import school.sorokin.javacore.Testing.Mockito.Pay.PaymentService;
import school.sorokin.javacore.Testing.Mockito.Pay.SBPPay;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class.getName());
        try {
            PaymentService sbp = new SBPPay();
            NotificationService tg = new TGSend();
            OrderRepository orderRepository = new OrderRepository();

            OrderService orderService1 = new OrderService(tg, sbp, orderRepository);
            Order order1 = orderService1.createOrder("закааааззз", false);
            System.out.println(order1);
        } catch (NoPayException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }
}
