package team.world.trade.order.infrastructure;

import org.springframework.stereotype.Repository;
import team.world.trade.order.domain.Order;
import team.world.trade.order.domain.OrderRepository;
import team.world.trade.order.infrastructure.mybatis.OrderMapper;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private OrderMapper orderMapper;

    public OrderRepositoryAdapter(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void save(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public Order findById(Long orderId) {
        return orderMapper.findById(orderId);
    }

}
