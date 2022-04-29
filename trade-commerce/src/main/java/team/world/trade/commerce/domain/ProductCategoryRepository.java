package team.world.trade.commerce.domain;

import java.util.List;

public interface ProductCategoryRepository {

    void batchInsert(List<ProductCategory> productCategories);


    List<ProductCategory> findAll();
}
