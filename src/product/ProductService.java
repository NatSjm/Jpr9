package product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;



public class ProductService {

    public static List<Product> getExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && (product.getPrice().compareTo(new BigDecimal("250")) > 0))
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedBooks(List<Product> products, BigDecimal discountValue) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.hasDiscount())
                .map(product -> new Product(
                        product.getType(),
                        product.getPrice().multiply(BigDecimal.ONE.subtract(discountValue)),
                        product.hasDiscount(),
                        product.getAddedAt()
                ))
                .collect(Collectors.toList());
    }

    public static Product findCheapestBook(List<Product> products) {
        Optional<Product> cheapestBook = products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice));
        return cheapestBook.orElseThrow(() -> new ProductNotFoundException("Book"));
    }

    public static List<Product> getThreeMostRecentlyAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getAddedAt).reversed())
                .limit(3)
                .toList();
    }

    public static BigDecimal calculateTotalCost(List<Product> products) {
        LocalDate currentDate = LocalDate.now();
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice().compareTo(new BigDecimal("75")) <= 0)
                .filter(product -> product.getAddedAt().getYear() == currentDate.getYear())
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }


}

