package team.world.trade.commerce.infrastructure;

import java.util.List;
import org.springframework.stereotype.Component;
import team.world.trade.commerce.domain.ProductCategory;
import team.world.trade.commerce.domain.ProductCategoryRepository;
import team.world.trade.commerce.infrastructure.mybatis.ProductCategoryMapper;

@Component
public class ProductCategoryAdapter implements ProductCategoryRepository {

    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryAdapter(
            ProductCategoryMapper productCategoryMapper) {
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public void save(ProductCategory productCategory) {
        productCategoryMapper.insert(productCategory);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryMapper.findAll();
    }
}
