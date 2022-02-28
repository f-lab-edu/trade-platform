package team.world.trade.commerce.domain;

import java.util.List;

public interface ProductCategoryRepository {

    void save(ProductCategory productCategory);

    List<ProductCategory> findAll();
}
