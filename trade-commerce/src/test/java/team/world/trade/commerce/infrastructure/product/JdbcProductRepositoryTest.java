package team.world.trade.commerce.infrastructure.product;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import team.world.trade.app.TradeAppApplication;
import team.world.trade.commerce.application.ProductService;
import team.world.trade.commerce.domain.Product;
import team.world.trade.commerce.domain.dtos.ProductDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TradeAppApplication.class)
class JdbcProductRepositoryTest {

    private final ProductService productService;

    @Autowired
    public JdbcProductRepositoryTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    void findById() {
        Optional<Product> found = productService.getProduct(1L);
        Product product = found.get();
        assertThat(product.getName()).isEqualTo("라즈베리파이3 모델B");
    }

    @Test
    void save() {
        ProductDto dto = new ProductDto("테스트물건",100,"테스트 물건에 대한 설명");
        Product save = productService.store(dto);
        Optional<Product> found = productService.getProduct(save.getId());
        Product foundProduct = found.get();
        assertThat(foundProduct.getName()).isEqualTo(dto.getName());
    }
}