package school.sorokin.javacore.Exception.Example.model;

import school.sorokin.javacore.Exception.Example.OrderValidationException;

public class OrderService {
    InventoryService inventoryService = new InventoryService();

    public void placeOrder(String productId, int quantity) throws OrderValidationException {
        if (productId==null || productId.isEmpty()) throw new OrderValidationException("Id не может быть пусты");
        if (quantity<=0) throw new OrderValidationException("Количество не может быть меньше 0");
        try {
            inventoryService.checkAvailability(productId);
        } catch (IllegalStateException e) {
            throw new OrderValidationException("Ошибка поиска товара", e);
        }
        System.out.println("Заказ создан");
    }
}
