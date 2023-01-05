import model.Category;
import model.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;
import service.ProductService;

import java.math.BigDecimal;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        /*
            Dla przykładowej kolekcji produktów wyznacz sumę cen produktów
            z wybranej kategorii.
        */

        // Wysokopoziomowe moduły nie powinny zależeć od modułów niskopoziomowych.
        // Zależności między nimi powinny wynikać z abstrakcji.
        Set<Product> products = Set.of(
                Product.of(1, "PROD A1", Category.A, BigDecimal.valueOf(100)),
                Product.of(2,"PROD A2", Category.A, BigDecimal.valueOf(200)),
                Product.of(3, "PROD B1", Category.B, BigDecimal.valueOf(300)),
                Product.of(4, "PROD B2", Category.B, BigDecimal.valueOf(400))
        );
        ProductRepository productRepository = new ProductRepositoryImpl(products);
        var productService = new ProductService(productRepository);
        System.out.println(productService.getTotalPriceForCategory(Category.A));
    }
}
