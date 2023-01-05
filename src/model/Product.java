package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final int id;
    private final String name;
    private final Category category;
    private final BigDecimal price;

    private Product(int id, String name, Category category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean hasCategory(Category category) {
        return this.category.equals(category);
    }

    @Override
    public String toString() {
        return "%d: [%s, %s, %s]".formatted(id, name, category, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && category == product.category && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price);
    }

    public static Product of(int id, String name, Category category, BigDecimal price) {
        return new Product(id, name, category, price);
    }
}
