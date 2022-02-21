package team.world.trade.commerce.infrastructure.product;

import java.util.Optional;
import team.world.trade.commerce.domain.Product;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);
}
