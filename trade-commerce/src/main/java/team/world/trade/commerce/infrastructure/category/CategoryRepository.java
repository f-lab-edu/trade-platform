package team.world.trade.commerce.infrastructure.category;

import java.util.Optional;
import team.world.trade.commerce.domain.Category;

public interface CategoryRepository {

    Category save(Category category);

    Optional<Category> findById(Long id);
}
