package team.world.trade.commerce.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    public void insertProductByCategory(CommerceRelation commerceRelation) {
        if (commerceRelation.getCatalogIds() == null) {
            throw new CategoryIdNotFoundException("There are no category Ids for this product");
        }
        
        List<ProductCategory> productCategories = getProductCategoryList(commerceRelation);
        productCategoryRepository.batchInsert(productCategories);
    }

    private List<ProductCategory> getProductCategoryList(CommerceRelation commerceRelation) {
        List<ProductCategory> productCategories = new ArrayList<>();
        Set<Long> catalogIds = commerceRelation.getCatalogIds();

        catalogIds.stream().forEach(id ->
                productCategories.add(new ProductCategory(commerceRelation.getProductId(), id)));
        return productCategories;
    }
}
