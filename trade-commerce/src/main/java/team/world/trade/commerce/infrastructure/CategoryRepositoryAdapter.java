package team.world.trade.commerce.infrastructure;

import java.util.Optional;
import team.world.trade.commerce.domain.Category;
import team.world.trade.commerce.domain.CategoryRepository;
import team.world.trade.commerce.infrastructure.mybatis.CategoryMapper;

public final class CategoryRepositoryAdapter implements CategoryRepository {

    private final CategoryMapper categoryMapper;

    public CategoryRepositoryAdapter(
            CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void save(Category category) {
        categoryMapper.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryMapper.findById(id);
    }
}
