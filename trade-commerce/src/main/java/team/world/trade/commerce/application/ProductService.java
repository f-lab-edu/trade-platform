package team.world.trade.commerce.application;

import java.util.Optional;
import org.springframework.stereotype.Service;
import team.world.trade.commerce.domain.Product;
import team.world.trade.commerce.domain.dtos.ProductDto;
import team.world.trade.commerce.infrastructure.category.CategoryRepository;
import team.world.trade.commerce.infrastructure.product.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product store(ProductDto dto) {
        Product product = new Product(dto.getName(), dto.getPrice(), dto.getDetail());
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(Long id) {
        Optional<Product> found = productRepository.findById(id);
        Product product = found.get();
        return Optional.ofNullable(product);
    }
}
