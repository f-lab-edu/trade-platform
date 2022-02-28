package team.world.trade.commerce.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findByCategoryId(Long id);
}
