package school.sorokin.javacore.Exception.Example.model;

public class InventoryService {
    public void checkAvailability(String productId) {
        throw new IllegalStateException();
    }
}
