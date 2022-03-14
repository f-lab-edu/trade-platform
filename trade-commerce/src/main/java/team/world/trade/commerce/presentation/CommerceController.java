package team.world.trade.commerce.presentation;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import team.world.trade.commerce.application.CommerceFacade;
import team.world.trade.commerce.application.payload.CategoryRequest;
import team.world.trade.commerce.application.payload.CommerceIdResponse;
import team.world.trade.commerce.application.payload.CommerceRequest;
import team.world.trade.common.response.ResponseApi;


@RestController
@RequestMapping("commerce")
public class CommerceController {

    private final CommerceFacade commerceFacade;

    public CommerceController(CommerceFacade commerceFacade) {
        this.commerceFacade = commerceFacade;
    }

    @GetMapping("/{id}")
    ResponseApi<?> get(@PathVariable("productId") Long id) {
        return ResponseApi.success(commerceFacade.get(id));
    }

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE})
    ResponseApi<?> create(@RequestPart CommerceRequest commerceRequest,
                          @RequestPart(required = false) MultipartFile multipartFile) {
        if (multipartFile != null) {
            commerceRequest.setImagePayload(commerceFacade.storeImage(multipartFile));
        }
        CommerceIdResponse commerceIdResponse = commerceFacade.create(commerceRequest);
        return ResponseApi.success(commerceIdResponse);
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
