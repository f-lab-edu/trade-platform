package team.world.trade.commerce.infrastructure;

import java.util.Optional;
import team.world.trade.commerce.domain.Product;
import team.world.trade.commerce.domain.ProductRepository;
import team.world.trade.commerce.infrastructure.mybatis.ProductMapper;

public final class ProductRepositoryAdapter implements ProductRepository {

    private ProductMapper productMapper;

    public ProductRepositoryAdapter(
            ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public void save(Product product) {
        productMapper.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productMapper.findById(id);
    }
}
