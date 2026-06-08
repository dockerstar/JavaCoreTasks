package school.sorokin.javacore.Stream.App;

import school.sorokin.javacore.Stream.App.model.Customer;
import school.sorokin.javacore.Stream.App.model.Order;
import school.sorokin.javacore.Stream.App.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
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
                new Order(2L, LocalDate.now(), LocalDate.of(2025, 12, 29), "NEW", productSet3),
                new Order(3L, LocalDate.now(), LocalDate.of(2026, 02, 10), "NEW", productSet4),
                new Order(4L, LocalDate.of(2026, 04, 25), LocalDate.of(2026, 05, 25), "PAYMENT", productSet1)
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
                new Customer(1L, "Alyona", 2L, orderSet2),
                new Customer(2L, "Vanya", 23L, orderSet3)
        );

        //1
        List<Product> productsSearch1 = productList.stream()
                .filter(s -> s.getCategory().equals("Books"))
                .filter(p -> p.getPrice().compareTo(new BigDecimal(100)) > 0)
                .collect(Collectors.toList());
        System.out.println(productsSearch1);

        //2
        List<Order> ordersSearch1 = orderList.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equals("Children's products")))
                .collect(Collectors.toList());
        System.out.println(ordersSearch1);

        //3
        Optional<BigDecimal> sum = productList.stream()
                .filter(p -> p.getCategory().equals("Toys"))
                .map(pr -> pr.getPrice().multiply(BigDecimal.valueOf(1.1)))
                .reduce((a, b) -> a.add(b));
        System.out.println(sum);

        //4
        List<Product> productSearch2 = customerList.stream()
                .filter(customer -> customer.getLevel() == 2L)
                .flatMap(c -> c.getOrders().stream()
                        .filter(o -> o.getDeliveryDate().isBefore(LocalDate.of(2026, 5, 1))
                                && o.getDeliveryDate().isAfter(LocalDate.of(2026, 1, 1))))
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.toList());
        System.out.println(productSearch2);


        //5
        List<Product> productSearch3 = productList.stream()
                .filter(pr -> pr.getCategory().equals("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(productSearch3);


        //6
        List<Order> orderSearch2 = orderList.stream()
                .sorted(Comparator.comparing(Order::getDeliveryDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("6// " + orderSearch2);

        //7
        List<Product> productSearch4 = orderList.stream()
                .filter(order -> order.getDeliveryDate().isEqual(LocalDate.now()))
                .peek(order -> System.out.println(order.getId()))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());
        System.out.println(productSearch4);

        //8
        Optional<BigDecimal> sum1 = orderList.stream()
                .filter(order -> order.getDeliveryDate().isBefore(LocalDate.of(2026, 2, 28))
                        && order.getDeliveryDate().isAfter(LocalDate.of(2026, 2, 1)))
                .flatMap(order -> order.getProducts().stream())
                .map(product -> product.getPrice())
                .reduce((a,b) -> a.add(b));
        System.out.println(sum1);

        //9

        long count = orderList.stream()
                .filter(order -> order.getDeliveryDate().isEqual(LocalDate.now()))
                .flatMap(order -> order.getProducts().stream())
                .count();

        BigDecimal average = orderList.stream()
                .filter(order -> order.getDeliveryDate().isEqual(LocalDate.now()))
                .flatMap(order -> order.getProducts().stream())
                .map(product -> product.getPrice())
                .reduce(BigDecimal.ZERO, (a,b)->a.add(b))
                .divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
        System.out.println(average);

        //10
        BigDecimal sumBook = productList.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .map(product -> product.getPrice())
                .reduce((a,b)->a.add(b))
                .get();
        System.out.println(sumBook);

        BigDecimal averageBook = productList.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .map(product -> product.getPrice())
                .reduce((a,b)->a.add(b))
                .map(s-> {
                    long countBook = productList.stream()
                            .filter(product -> product.getCategory().equals("Books"))
                            .count();
                    return s.divide(BigDecimal.valueOf(countBook), 1, RoundingMode.HALF_UP);
                })
                .get();
        System.out.println(averageBook);

        BigDecimal maxBook = productList.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .max(Comparator.comparing(Product::getPrice))
                .map(Product::getPrice)
                .get();
        System.out.println(maxBook);

        BigDecimal minBook = productList.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .min(Comparator.comparing(Product::getPrice))
                .map(product -> product.getPrice())
                .get();
        System.out.println(minBook);

        //11
        Map<Long, Integer> map1 = orderList.stream()
                .collect(Collectors.toMap(
                        Order::getId,
                        order -> order.getProducts().size()
                ));
        System.out.println(map1);

        //12
        Map<Customer, List<Order>> map2 = customerList.stream()
                .collect(Collectors.toMap(
                        customer -> customer,
                        customer -> customer.getOrders().stream().toList()
                ));
        System.out.println(map2);

        //13
        Map<Long, BigDecimal> map3 = orderList.stream()
                .collect(Collectors.toMap(
                        order -> order.getId(),
                        order -> {
                            Set<Product> productList1 = order.getProducts();
                            BigDecimal sumPr = productList1.stream()
                                    .map(product -> product.getPrice())
                                    .reduce((a,b)->a.add(b))
                                    .get();
                            return sumPr;
                        }
                ));
        System.out.println(map3);

        //14
        Map<String, List<String>> map4 = productList.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())
                        )
                );
        System.out.println(map4);

        //15
        Map<String, Optional<Product>> map5 = productList.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))
                ));
        System.out.println(map5);
    }
}
