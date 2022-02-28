package team.world.trade.commerce.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.world.trade.commerce.application.CommerceFacade;
import team.world.trade.commerce.application.payload.CategoryRequest;
import team.world.trade.commerce.application.payload.CommerceRequest;
import team.world.trade.common.response.ResponseApi;


@RestController
@RequestMapping("commerce")
public class CommerceController {

    private final CommerceFacade commerceFacade;

    public CommerceController(CommerceFacade commerceFacade) {
        this.commerceFacade = commerceFacade;
    }

    @GetMapping("/get/{id}")
    ResponseApi<?> get(@PathVariable("productId") Long id) {
        return ResponseApi.success(commerceFacade.get(id));
    }

    @PostMapping("/register")
    ResponseApi<?> create(@RequestBody CommerceRequest commerceRequest) {
        return ResponseApi.success(commerceFacade.create(commerceRequest));
    }

    @PostMapping("/addCategory")
    ResponseApi<?> addCategory(@RequestBody CategoryRequest categoryRequest) {
        return ResponseApi.success(commerceFacade.addCategory(categoryRequest));
    }

    @GetMapping("/get/{categoryId}/category")
    ResponseApi<?> getProductsInCategory(@PathVariable("categoryId") Long id) {
        return ResponseApi.success(commerceFacade.getProductsInCategory(id));
    }
}
