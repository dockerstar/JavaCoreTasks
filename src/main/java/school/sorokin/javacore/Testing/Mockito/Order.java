package school.sorokin.javacore.Testing.Mockito;

import school.sorokin.javacore.Testing.Mockito.Pay.PaymentService;

import java.util.Objects;

public class Order {
    private Integer id;
    private String title;
    private boolean statusPay = false;
    private String typePay;
    private String toSend;

    public Order(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setTypePay(String typePay) {
        this.typePay = typePay;
    }

    public String getTypePay() {
        return typePay;
    }

    public void setToSend(String toSend) {
        this.toSend = toSend;
    }

    public String getToSend() {
        return toSend;
    }

    public boolean isStatusPay() {
        return statusPay;
    }

    public void setStatusPay(boolean statusPay) {
        this.statusPay = statusPay;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(title, order.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", statusPay=" + statusPay +
                ", typePay='" + typePay + '\'' +
                ", toSend='" + toSend + '\'' +
                '}';
    }
}
