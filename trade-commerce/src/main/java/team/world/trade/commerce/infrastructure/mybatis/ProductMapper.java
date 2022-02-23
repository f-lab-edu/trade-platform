package team.world.trade.commerce.infrastructure.mybatis;

import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import team.world.trade.commerce.domain.Product;

@Mapper
public interface ProductMapper {

    void insert(Product product);

    Optional<Product> findById(Long id);

}
