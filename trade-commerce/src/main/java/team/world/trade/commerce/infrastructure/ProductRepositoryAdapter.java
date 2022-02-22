package team.world.trade.commerce.infrastructure;

import java.util.Optional;
import team.world.trade.commerce.domain.Product;
import team.world.trade.commerce.domain.ProductRepository;

public final class ProductRepositoryAdapter implements ProductRepository {

    private ProductMapper myBatisProductRepository;

    public ProductRepositoryAdapter(
            ProductMapper myBatisProductRepository) {
        this.myBatisProductRepository = myBatisProductRepository;
    }

    @Override
    public void save(Product product) {
        myBatisProductRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return myBatisProductRepository.findById(id);
    }
}
