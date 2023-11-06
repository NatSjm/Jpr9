package product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {
    final private String type;
    final private BigDecimal price;
    final private boolean discountCanBeApplyed;
    final private LocalDateTime additionDate;
    private static int nextId = 1;

    final private int id;

    public Product(String type, BigDecimal price, boolean discountCanBeApplyed, LocalDateTime additionDate) {
        this.id = nextId++;
        this.type = type;
        this.price = price;
        this.discountCanBeApplyed = discountCanBeApplyed;
        this.additionDate = additionDate;
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
        return discountCanBeApplyed;
    }

    public LocalDateTime getAdditionDate() {
        return additionDate;
    }


    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", has discount=" + discountCanBeApplyed +
                ", date=" + additionDate +
                '}';
    }
}
