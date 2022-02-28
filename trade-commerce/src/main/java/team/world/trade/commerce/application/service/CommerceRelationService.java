package team.world.trade.commerce.application.service;

import org.springframework.stereotype.Service;
import team.world.trade.commerce.application.exception.CategoryIdNotFoundException;
import team.world.trade.commerce.application.payload.CommerceRelation;
import team.world.trade.commerce.domain.ProductCategory;
import team.world.trade.commerce.domain.ProductCategoryRepository;

@Service
public final class CommerceRelationService {

    private ProductCategoryRepository productCategoryRepository;

    public CommerceRelationService(
            ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public void process(CommerceRelation commerceRelation) {
        if (commerceRelation.getCatalogIds() == null) {
            throw new CategoryIdNotFoundException("There are no category Ids for this product");
        }

        Long productId = commerceRelation.getProductId();
        commerceRelation.getCatalogIds().stream()
                .forEach(id -> productCategoryRepository.save(new ProductCategory(productId, id)));
    }
}
