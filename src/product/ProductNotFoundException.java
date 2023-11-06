package product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String category) {
        super("Product [category: " + category + "] not found");
    }
}