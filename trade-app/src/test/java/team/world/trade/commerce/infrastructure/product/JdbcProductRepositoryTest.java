package team.world.trade.commerce.infrastructure.product;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import team.world.trade.app.TradeAppApplication;
import team.world.trade.commerce.domain.Product;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TradeAppApplication.class)
class JdbcProductRepositoryTest {

    private final ProductRepository productRepository;


    @Autowired
    public JdbcProductRepositoryTest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    void findById() {
        Optional<Product> found = productRepository.findById(1L);
        Product product = found.get();
        assertThat(product.getName()).isEqualTo("라즈베리파이3 모델B");
    }

    @Test
    void save() {
        Product product = new Product("테스트물건", 100, "테스트 물건에 대한 설명");
        Product save = productRepository.save(product);
        Optional<Product> found = productRepository.findById(save.getId());
        Product foundProduct = found.get();
        assertThat(foundProduct.getName()).isEqualTo(product.getName());
    }
}