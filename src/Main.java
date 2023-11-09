import product.Product;
import product.ProductNotFoundException;
import product.ProductService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", new BigDecimal("300"), false, LocalDateTime.now()));
        products.add(new Product("Book", new BigDecimal("200"), true, LocalDateTime.now()));
        products.add(new Product("Electronics", new BigDecimal("500"), true, LocalDateTime.now()));
        products.add(new Product("Book", new BigDecimal("150"), true, LocalDateTime.now()));
        products.add(new Product("Clothing", new BigDecimal("50"), true, LocalDateTime.now()));

        // 1.2
        List<Product> expensiveBooks = ProductService.getExpensiveBooks(products);

        System.out.println("Expensive Books:");
        expensiveBooks.forEach(System.out::println);

        // 2.2
        BigDecimal discountPercentage = new BigDecimal("0.10");
        List<Product> discountedBooks = ProductService.getDiscountedBooks(products, discountPercentage);

        System.out.println("Discounted Books:");
        discountedBooks.forEach(System.out::println);

        //3.2, 3.3
        List<Product> productsToFindCheapest = List.of(
                new Product("Books", new BigDecimal("20"), false, LocalDateTime.now()),
                new Product("Books", new BigDecimal("15"), true, LocalDateTime.now()),
                new Product("Electronics", new BigDecimal("200"), true, LocalDateTime.now())
        );

        try {
            Product cheapestBook = ProductService.findCheapestBook(productsToFindCheapest);
            System.out.println("Cheapest Book: " + cheapestBook.getPrice());
        } catch (ProductNotFoundException e) {
            System.err.println(e.getMessage());
        }


        //4.2
        List<Product> recentProducts = new ArrayList<>();
        recentProducts.add(new Product("Book", new BigDecimal("20"), false, LocalDateTime.now().minusDays(2)));
        recentProducts.add(new Product("Electronics", new BigDecimal("200"), true, LocalDateTime.now().minusHours(3)));
        recentProducts.add(new Product("Clothing", new BigDecimal("50"), true, LocalDateTime.now().minusMinutes(30)));
        recentProducts.add(new Product("Book", new BigDecimal("30"), true, LocalDateTime.now().minusDays(1)));
        recentProducts.add(new Product("Electronics", new BigDecimal("300"), true, LocalDateTime.now()));

        List<Product> recentlyAddedProducts = ProductService.getThreeMostRecentlyAddedProducts(recentProducts);

        System.out.println("Three Most Recently Added Products:");
        recentlyAddedProducts.forEach(product -> System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice() + ", Date Added: " + product.getAddedAt()));

        //5.2
        List<Product> thisYearProducts = new ArrayList<>();
        thisYearProducts.add(new Product("Book", new BigDecimal("20"), false, LocalDateTime.now().minusMonths(2)));
        thisYearProducts.add(new Product("Book", new BigDecimal("60"), true, LocalDateTime.now().minusDays(2)));
        thisYearProducts.add(new Product("Book", new BigDecimal("80"), true, LocalDateTime.now()));
        thisYearProducts.add(new Product("Book", new BigDecimal("70"), true, LocalDateTime.now().minusYears(1)));

        BigDecimal totalCost = ProductService.calculateTotalCost(thisYearProducts);

        System.out.println("Total Cost of  Books: " + totalCost);


        //6.2
        List<Product> productsToGroup = new ArrayList<>();
        productsToGroup.add(new Product("Book", new BigDecimal("20"), false, LocalDateTime.now().minusMonths(2)));
        productsToGroup.add(new Product("Book", new BigDecimal("60"), true, LocalDateTime.now().minusDays(2)));
        productsToGroup.add(new Product("Toy", new BigDecimal("80"), true, LocalDateTime.now()));
        productsToGroup.add(new Product("Toy", new BigDecimal("70"), true, LocalDateTime.now().minusYears(1)));

        Map<String, List<Product>> groupedProducts = ProductService.groupProductsByType(productsToGroup);
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Product product : entry.getValue()) {
                System.out.println("Id: " + product.getId() + ", Price: " + product.getPrice() + ", Date Added: " + product.getAddedAt());
            }
        }
    }
}