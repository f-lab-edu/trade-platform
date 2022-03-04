package team.world.trade.commerce.infrastructure.mybatis;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import team.world.trade.commerce.domain.ProductCategory;

@Mapper
public interface ProductCategoryMapper {

    void batchInsert(List<ProductCategory> productCategories);

    List<ProductCategory> findAll();
}
