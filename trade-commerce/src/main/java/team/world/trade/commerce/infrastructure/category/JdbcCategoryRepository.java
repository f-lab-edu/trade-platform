package team.world.trade.commerce.infrastructure.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import team.world.trade.commerce.domain.Category;

@Repository
public class JdbcCategoryRepository implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Category save(Category category) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        jdbcInsert.withTableName("category").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", category.getName());
        Number key = jdbcInsert.executeAndReturnKey(parameters);
        category.setId(key.longValue());
        return category;
    }

    @Override
    public Optional<Category> findById(Long id) {
        List<Category> result =
                jdbcTemplate.query("select * from category where id = ? ", categoryRowMapper(), id);
        return result.stream().findAny();
    }

    private RowMapper<Category> categoryRowMapper() {
        return (rs, rowName) -> {
            Category category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            return category;
        };
    }
}
