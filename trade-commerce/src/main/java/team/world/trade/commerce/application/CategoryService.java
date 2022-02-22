package team.world.trade.commerce.application;

import org.springframework.stereotype.Service;
import team.world.trade.commerce.application.request.CategoryDto;
import team.world.trade.commerce.application.response.CategoryResponse;
import team.world.trade.commerce.domain.Category;
import team.world.trade.commerce.infrastructure.mybatis.CategoryMapper;

@Service
public class CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponse registerCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto.getName());
        categoryMapper.save(category);
        return new CategoryResponse(category.getName());
    }

    public CategoryResponse getCategory(Long id) {
        Category category = categoryMapper.findById(id).orElseThrow();
        return new CategoryResponse(category.getName());
    }
}