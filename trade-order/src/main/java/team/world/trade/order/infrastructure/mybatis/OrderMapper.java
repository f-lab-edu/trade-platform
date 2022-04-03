package team.world.trade.order.infrastructure.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.world.trade.order.domain.Order;

@Mapper
public interface OrderMapper {

    void insert(Order order);

    Order findById(Long orderId);

}
