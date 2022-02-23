package team.world.trade.user.infrastructure.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "team.world.trade.user.infrastructure")
public class UserMybatisConfiguration {
}
