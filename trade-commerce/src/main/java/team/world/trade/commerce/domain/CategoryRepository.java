package team.world.trade.commerce.domain;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository {

    void save(Category category);

    Optional<Category> findById(Long id);
}
