package team.world.trade.commerce.presentation;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.world.trade.commerce.application.ProductService;
import team.world.trade.commerce.domain.Product;

@RequestMapping("/api/commerce")
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/test")
    public void test() {
        Optional<Product> product = productService.getProduct(1L);
        int a = 0;
    }
}
