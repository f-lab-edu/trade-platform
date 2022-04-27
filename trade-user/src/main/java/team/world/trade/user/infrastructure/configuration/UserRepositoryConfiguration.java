package team.world.trade.user.infrastructure.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@MapperScan(basePackages = "team.world.trade.user.infrastructure")
@Configuration
@EntityScan("team.world")
@EnableJpaRepositories("team.world")
public class UserRepositoryConfiguration {
}
