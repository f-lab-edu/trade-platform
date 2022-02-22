package team.world.trade.commerce.infrastructure;

import java.util.Optional;
import team.world.trade.commerce.domain.Category;
import team.world.trade.commerce.domain.CategoryRepository;

public final class CategoryRepositoryAdapter implements CategoryRepository {

    private final CategoryMapper myBatisCategoryRepository;

    public CategoryRepositoryAdapter(
            CategoryMapper myBatisCategoryRepository) {
        this.myBatisCategoryRepository = myBatisCategoryRepository;
    }

    @Override
    public void save(Category category) {
        myBatisCategoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return myBatisCategoryRepository.findById(id);
    }
}
