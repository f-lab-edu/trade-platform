package team.world.trade.commerce.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import team.world.trade.commerce.application.request.CategoryDto;
import team.world.trade.commerce.application.response.CategoryResponse;
import team.world.trade.commerce.domain.Category;
import team.world.trade.commerce.domain.CategoryRepository;

@Service
@MapperScan(basePackages = "team.world.trade.commerce")
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(
            CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse registerCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto.getName());
        categoryRepository.save(category);
        return new CategoryResponse(category.getName());
    }

    public CategoryResponse getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return new CategoryResponse(category.getName());
    }
}