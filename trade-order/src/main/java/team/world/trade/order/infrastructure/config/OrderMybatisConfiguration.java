package team.world.trade.order.infrastructure.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "team.world.trade.order.infrastructure")
public class OrderMybatisConfiguration {
}
