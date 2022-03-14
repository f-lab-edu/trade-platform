package team.world.trade.commerce.application.service;

import java.util.List;
import org.springframework.stereotype.Service;
import team.world.trade.commerce.application.payload.CategoryRequest;
import team.world.trade.commerce.application.payload.CommerceIdResponse;
import team.world.trade.commerce.application.payload.CommerceRequest;
import team.world.trade.commerce.application.payload.CommerceResponse;
import team.world.trade.commerce.domain.Category;
import team.world.trade.commerce.domain.CategoryRepository;
import team.world.trade.commerce.domain.Product;
import team.world.trade.commerce.domain.ProductRepository;

@Service
public class CommerceService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CommerceService(CategoryRepository categoryRepository,
                           ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public CommerceResponse get(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return CommerceResponse.of(
                product.getName(),
                product.getPrice(),
                product.getDetail());
    }

    public CommerceIdResponse create(CommerceRequest commerceRequest) {
        Product product = Product.of(
                commerceRequest.getName(),
                commerceRequest.getPrice(),
                commerceRequest.getDetail());

        if (commerceRequest.getImagePayload() != null) {
            product.setImagePath(commerceRequest.getImagePayload().getPath());
        }

        productRepository.save(product);
        return CommerceIdResponse.of(product.getId());
    }

    public CommerceIdResponse addCategory(CategoryRequest categoryRequest) {
        Category category = Category.of(categoryRequest.getName());
        categoryRepository.save(category);
        return CommerceIdResponse.of(category.getId());
    }

    public List<Product> findInCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

}