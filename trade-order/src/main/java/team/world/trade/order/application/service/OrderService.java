package team.world.trade.order.application.service;

import org.springframework.stereotype.Service;
import team.world.trade.order.application.payload.OrderRequest;
import team.world.trade.order.application.payload.OrderResponse;
import team.world.trade.order.domain.Order;
import team.world.trade.order.domain.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = new Order(orderRequest.getUsername(), orderRequest.getProductId(),
                orderRequest.getAddress(), orderRequest.getZipcode());
        orderRepository.save(order);

        return new OrderResponse(order.getOrderId(), order.getProductId());
    }
}
