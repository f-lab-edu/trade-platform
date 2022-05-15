package team.world.trade.user.infrastructure.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@MapperScan(basePackages = "team.world.trade.user.infrastructure")
@EntityScan("team.world.trade.user")
@EnableJpaRepositories("team.world.trade.user")
public class UserRepositoryConfiguration {
}
