package team.world.trade.commerce.infrastructure.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import team.world.trade.commerce.domain.Product;

@Repository
public class JdbcProductRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product save(Product product) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("product").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", product.getName());
        parameters.put("detail", product.getDetail());
        parameters.put("price", product.getPrice());
        Number key = jdbcInsert.executeAndReturnKey(parameters);
        product.setId(key.longValue());
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        String sql = "select * from product where id = ?";
        List<Product> result = jdbcTemplate.query(sql, productRowMapper(), id);
        return result.stream().findAny();
    }


    private RowMapper<Product> productRowMapper() {
        return (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setDetail(rs.getString("detail"));
            product.setPrice(rs.getInt("price"));
            return product;
        };
    }
}
