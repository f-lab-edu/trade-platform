package team.world.trade.commerce.infrastructure.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan(basePackages = "team.world.trade.commerce.infrastructure")
public class CommerceMybatisConfiguration {

}
