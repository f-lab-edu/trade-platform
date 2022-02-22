package team.world.trade.commerce.application;

import org.springframework.stereotype.Service;
import team.world.trade.commerce.application.request.ProductDto;
import team.world.trade.commerce.application.response.ProductResponse;
import team.world.trade.commerce.domain.Product;
import team.world.trade.commerce.infrastructure.mybatis.ProductMapper;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ProductResponse registerProduct(ProductDto dto) {
        Product product = new Product(dto.getName(), dto.getPrice(), dto.getDetail());
        productMapper.save(product);
        return new ProductResponse(product.getName());
    }

    public ProductResponse getProduct(Long id) {
        Product product = productMapper.findById(id).orElseThrow();
        return new ProductResponse(product.getName());
    }
}
