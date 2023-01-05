package repository;

import model.Category;
import model.Product;

import java.util.Set;

public sealed interface ProductRepository permits ProductRepositoryImpl {
    Set<Product> findAllByCategory(Category category);
}
