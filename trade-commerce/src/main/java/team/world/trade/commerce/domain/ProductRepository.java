package team.world.trade.commerce.domain;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {

    void save(Product product);

    Optional<Product> findById(Long id);

}
