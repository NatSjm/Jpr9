package product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {
    final private String type;
    final private BigDecimal price;
    final private boolean discount;
    final private LocalDateTime addedAt;
    private static int nextId = 1;

    final private int id;

    public Product(String type, BigDecimal price, boolean discount, LocalDateTime addedAt) {
        this.id = nextId++;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.addedAt = addedAt;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }


    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", has discount=" + discount +
                ", date=" + addedAt +
                '}';
    }
}
