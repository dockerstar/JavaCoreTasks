package school.sorokin.javacore.Exception.Example;

import school.sorokin.javacore.Exception.Example.model.OrderService;

public class ExampleLesson {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            orderService.placeOrder("asd", 2);
        } catch (OrderValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
