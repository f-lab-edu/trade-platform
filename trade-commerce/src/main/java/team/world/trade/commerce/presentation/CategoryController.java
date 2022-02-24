package team.world.trade.commerce.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.world.trade.commerce.application.CategoryService;
import team.world.trade.commerce.application.request.CategoryDto;
import team.world.trade.common.response.ResponseApi;

@RequestMapping("/api/commerce")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category/register")
    public ResponseApi<?> registerCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseApi.success(categoryService.registerCategory(categoryDto));
    }
}
