package team.world.trade.order.domain;


public interface OrderRepository {

    void save(Order order);

    Order findById(Long orderId);
}
