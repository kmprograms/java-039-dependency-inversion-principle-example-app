package repository;

import model.Category;
import model.Product;

import java.util.Set;
import java.util.stream.Collectors;

public final class ProductRepositoryImpl implements ProductRepository {
    private final Set<Product> products;

    public ProductRepositoryImpl(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> findAllByCategory(Category category) {
        return products
                .stream()
                .filter(product -> product.hasCategory(category))
                .collect(Collectors.toSet());
    }

}
