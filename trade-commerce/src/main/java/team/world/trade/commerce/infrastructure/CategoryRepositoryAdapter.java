package team.world.trade.commerce.infrastructure;

import java.util.Optional;
import org.springframework.stereotype.Component;
import team.world.trade.commerce.domain.Category;
import team.world.trade.commerce.domain.CategoryRepository;
import team.world.trade.commerce.infrastructure.mybatis.CategoryMapper;


@Component
public class CategoryRepositoryAdapter implements CategoryRepository {

    private final CategoryMapper categoryMapper;

    public CategoryRepositoryAdapter(
            CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void save(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryMapper.findById(id);
    }

}
