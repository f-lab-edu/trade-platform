package team.world.trade.commerce.domain;

import java.util.Optional;

public interface CategoryRepository {

    void save(Category category);

    Optional<Category> findById(Long id);
}
