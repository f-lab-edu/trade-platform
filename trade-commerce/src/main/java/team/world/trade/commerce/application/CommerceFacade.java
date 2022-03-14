package team.world.trade.commerce.application;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import team.world.trade.commerce.application.payload.CategoryRequest;
import team.world.trade.commerce.application.payload.CommerceIdResponse;
import team.world.trade.commerce.application.payload.CommerceRelation;
import team.world.trade.commerce.application.payload.CommerceRequest;
import team.world.trade.commerce.application.payload.CommerceResponse;
import team.world.trade.commerce.application.payload.ImagePayload;
import team.world.trade.commerce.application.payload.ProductCategoryResponse;
import team.world.trade.commerce.application.payload.ResponseItems;
import team.world.trade.commerce.application.service.CommerceImageService;
import team.world.trade.commerce.application.service.CommerceRelationService;
import team.world.trade.commerce.application.service.CommerceService;
import team.world.trade.commerce.domain.Product;

@Component
public class CommerceFacade {
    private static final Logger logger = LoggerFactory.getLogger(CommerceFacade.class);

    private final CommerceService commerceService;
    private final CommerceRelationService commerceRelationService;
    private final CommerceImageService commerceImageService;

    public CommerceFacade(CommerceService commerceService,
                          CommerceRelationService commerceRelationService,
                          CommerceImageService commerceImageService) {
        this.commerceService = commerceService;
        this.commerceRelationService = commerceRelationService;
        this.commerceImageService = commerceImageService;
    }

    public CommerceResponse get(Long id) {
        return commerceService.get(id);
    }

    public CommerceIdResponse create(CommerceRequest commerceRequest) {
        CommerceIdResponse commerceIdResponse = commerceService.create(commerceRequest);
        CommerceRelation relation = CommerceRelation.of(commerceIdResponse.getId(),
                commerceRequest.getCategoryIds());
        try {
            commerceRelationService.insertProductByCategory(relation);
        } catch (Exception e) {
            logger.info("The catalog id have not been specified for product : {}",
                    commerceIdResponse.getId());
        }
        return commerceIdResponse;
    }

    public CommerceIdResponse addCategory(CategoryRequest categoryRequest) {
        return commerceService.addCategory(categoryRequest);
    }

    public ImagePayload storeImage(MultipartFile multipartFile) {
        return commerceImageService.store(multipartFile);
    }

    public ResponseItems getProductsInCategory(Long id) {
        List<Product> products = commerceService.findInCategoryId(id);
        return new ResponseItems(ProductCategoryResponse.convert(products));
    }
}
