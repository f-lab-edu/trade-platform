package team.world.trade.commerce.infrastructure;

import java.util.List;
import org.springframework.stereotype.Component;
import team.world.trade.commerce.domain.ProductCategory;
import team.world.trade.commerce.domain.ProductCategoryRepository;
import team.world.trade.commerce.infrastructure.mybatis.ProductCategoryMapper;

@Component
public class ProductCategoryRepositoryAdapter implements ProductCategoryRepository {

    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryRepositoryAdapter(
            ProductCategoryMapper productCategoryMapper) {
        this.productCategoryMapper = productCategoryMapper;
    }


    @Override
    public void batchInsert(List<ProductCategory> productCategories) {
        productCategoryMapper.batchInsert(productCategories);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryMapper.findAll();
    }
}
