package team.world.trade.commerce.infrastructure.mybatis;

import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import team.world.trade.commerce.domain.Category;

@Mapper
public interface CategoryMapper {

    void insert(Category category);

    Optional<Category> findById(Long id);

}
