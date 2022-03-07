package team.world.trade.commerce.application;

import java.util.List;
import org.springframework.stereotype.Component;
import team.world.trade.commerce.application.payload.CategoryRequest;
import team.world.trade.commerce.application.payload.CommerceIdResponse;
import team.world.trade.commerce.application.payload.CommerceRelation;
import team.world.trade.commerce.application.payload.CommerceRequest;
import team.world.trade.commerce.application.payload.CommerceResponse;
import team.world.trade.commerce.application.payload.ProductCategoryResponse;
import team.world.trade.commerce.application.payload.ResponseItems;
import team.world.trade.commerce.application.service.CommerceRelationService;
import team.world.trade.commerce.application.service.CommerceService;
import team.world.trade.commerce.domain.Product;

@Component
public class CommerceFacade {

    private final CommerceService commerceService;
    private final CommerceRelationService commerceRelationService;

    public CommerceFacade(CommerceService commerceService,
                          CommerceRelationService commerceRelationService) {
        this.commerceService = commerceService;
        this.commerceRelationService = commerceRelationService;
    }

    public CommerceResponse get(Long id) {
        return commerceService.get(id);
    }

    public CommerceIdResponse create(CommerceRequest commerceRequest) {
        CommerceIdResponse commerceIdResponse = commerceService.create(commerceRequest);

        CommerceRelation relation =
                CommerceRelation.of(commerceIdResponse.getId(), commerceRequest.getCategoryIds());
        commerceRelationService.insertProductByCategory(relation);

        return commerceIdResponse;
    }

    public CommerceIdResponse addCategory(CategoryRequest categoryRequest) {
        return commerceService.addCategory(categoryRequest);
    }

    public ResponseItems getProductsInCategory(Long id) {
        List<Product> products = commerceService.findInCategoryId(id);
        return new ResponseItems(ProductCategoryResponse.convert(products));
    }

}
