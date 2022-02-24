package team.world.trade.commerce.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.world.trade.commerce.application.ProductService;
import team.world.trade.commerce.application.request.ProductDto;
import team.world.trade.common.response.ResponseApi;

@RequestMapping("/api/commerce")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product/register")
    public ResponseApi<?> registerProduct(@RequestBody ProductDto productDto) {
        return ResponseApi.success(productService.registerProduct(productDto));
    }

    @GetMapping("/product/findProduct")
    public ResponseApi<?> getProduct(@RequestParam("id") Long id) {
        return ResponseApi.success(productService.getProduct(id));
    }
}
