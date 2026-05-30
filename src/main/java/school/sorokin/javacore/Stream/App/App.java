package school.sorokin.javacore.Stream.App;

import school.sorokin.javacore.Stream.App.model.Customer;
import school.sorokin.javacore.Stream.App.model.Order;
import school.sorokin.javacore.Stream.App.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Product> productList = List.of(
                new Product(0L, "Push", "Books", BigDecimal.valueOf(1000)),
                new Product(1L, "Oneg", "Books", BigDecimal.valueOf(100)),
                new Product(2L, "Ler", "Books", BigDecimal.valueOf(200)),
                new Product(3L, "Dost", "Toys", BigDecimal.valueOf(2000)),
                new Product(4L, "Car", "Toys", BigDecimal.valueOf(2200)),
                new Product(5L, "Poezd", "Toys", BigDecimal.valueOf(10000)),
                new Product(6L, "Chil smes", "Children's products", BigDecimal.valueOf(100)),
                new Product(7L, "Juse", "Children's products", BigDecimal.valueOf(10)),
                new Product(8L, "Pampers", "Children's products", BigDecimal.valueOf(900))
                );

        Set<Product> productSet1 = new HashSet<>();
        productSet1.add(productList.get(0));
        productSet1.add(productList.get(5));
        Set<Product> productSet2 = new HashSet<>();
        productSet2.add(productList.get(1));
        productSet2.add(productList.get(4));
        Set<Product> productSet3 = new HashSet<>();
        productSet3.add(productList.get(0));
        productSet3.add(productList.get(3));
        Set<Product> productSet4 = new HashSet<>();
        productSet4.add(productList.get(2));
        productSet4.add(productList.get(6));


        List<Order> orderList = List.of(
                new Order(0L, LocalDate.now(), LocalDate.now(), "PAYMENT", productSet1),
                new Order(1L, LocalDate.now(), LocalDate.now(), "STATLESS", productSet2),
                new Order(2L, LocalDate.now(), LocalDate.now(), "NEW", productSet3),
                new Order(3L, LocalDate.now(), LocalDate.now(), "NEW", productSet4),
                new Order(4L, LocalDate.now(), LocalDate.now(), "PAYMENT", productSet1)
        );

        Set<Order> orderSet1 = new HashSet<>();
        orderSet1.add(orderList.get(0));
        orderSet1.add(orderList.get(2));
        Set<Order> orderSet2 = new HashSet<>();
        orderSet2.add(orderList.get(1));
        orderSet2.add(orderList.get(3));
        Set<Order> orderSet3 = new HashSet<>();
        orderSet3.add(orderList.get(0));
        orderSet3.add(orderList.get(3));


        List<Customer> customerList = List.of(
                new Customer(0L, "Dima", 63L, orderSet1),
                new Customer(1L, "Alyona", 1L, orderSet2),
                new Customer(3L, "Vanya", 23L, orderSet3)
        );

        //1
        List<Product> productsSearch1 = productList.stream()
                .filter(s->s.getCategory().equals("Books"))
                .filter(p->p.getPrice().compareTo(new BigDecimal(100))>0)
                .collect(Collectors.toList());
        System.out.println(productsSearch1);

        //2
        List<Order> ordersSearch1 = orderList.stream()
                .filter(o-> o.getProducts().stream()
                        .anyMatch(p->p.getCategory().equals("Children's products")))
                .collect(Collectors.toList());
        System.out.println(ordersSearch1);

        //3
        Optional<BigDecimal> sum= productList.stream()
                .filter(p->p.getCategory().equals("Toys"))
                .map(pr->pr.getPrice().multiply(BigDecimal.valueOf(1.1)))
                .reduce((a, b) -> a.add(b));
        System.out.println(sum);
    }
}
