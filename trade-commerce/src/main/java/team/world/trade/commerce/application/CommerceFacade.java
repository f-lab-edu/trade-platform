package team.world.trade.commerce.application;

import org.springframework.stereotype.Component;
import team.world.trade.commerce.application.payload.CategoryRequest;
import team.world.trade.commerce.application.payload.CommerceIdResponse;
import team.world.trade.commerce.application.payload.CommerceRequest;
import team.world.trade.commerce.application.payload.CommerceResponse;
import team.world.trade.commerce.application.service.CommerceService;

@Component
public class CommerceFacade {

    private final CommerceService commerceService;

    public CommerceFacade(CommerceService commerceService) {
        this.commerceService = commerceService;
    }

    public CommerceResponse get(Long id) {
        return commerceService.get(id);
    }

    public CommerceIdResponse create(CommerceRequest commerceRequest) {
        return commerceService.create(commerceRequest);
    }
    
    public CommerceIdResponse addCategory(CategoryRequest categoryRequest) {
        return commerceService.addCategory(categoryRequest);
    }
}
