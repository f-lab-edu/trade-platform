package team.world.trade.common.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataSourceConfig {

    @Bean
    public JdbcTemplate dataSource(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
