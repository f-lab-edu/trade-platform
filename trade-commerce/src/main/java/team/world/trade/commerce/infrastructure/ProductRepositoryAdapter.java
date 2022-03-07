package team.world.trade.commerce.infrastructure;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import team.world.trade.commerce.domain.Product;
import team.world.trade.commerce.domain.ProductRepository;
import team.world.trade.commerce.infrastructure.mybatis.ProductMapper;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private ProductMapper productMapper;

    public ProductRepositoryAdapter(
            ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public void save(Product product) {
        productMapper.insert(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        return productMapper.findByCategoryId(id);
    }
}
