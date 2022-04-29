package team.world.trade.commerce.infrastructure.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@MapperScan(basePackages = "team.world.trade.commerce.infrastructure")
@EntityScan("team.world.trade.commerce")
@EnableJpaRepositories("team.world.trade.commerce")
public class CommerceConfiguration {

}
