package team.world.trade.commerce.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import team.world.trade.commerce.application.request.ProductDto;
import team.world.trade.commerce.application.response.ProductResponse;
import team.world.trade.commerce.domain.Product;
import team.world.trade.commerce.domain.ProductRepository;

@Service
@MapperScan(basePackages = "team.world.trade.commerce")
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse registerProduct(ProductDto dto) {
        Product product = new Product(dto.getName(), dto.getPrice(), dto.getDetail());
        productRepository.save(product);
        return new ProductResponse(product.getName());
    }

    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return new ProductResponse(product.getName());
    }
}
