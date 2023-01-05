package service;

import model.Category;
import model.Product;
import repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public BigDecimal getTotalPriceForCategory(Category category) {
        Objects.requireNonNull(category, "Category is null");
        return productRepository
                .findAllByCategory(category)
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
