package team.world.trade.order.application;

import org.springframework.stereotype.Component;
import team.world.trade.order.application.payload.OrderRequest;
import team.world.trade.order.application.payload.OrderResponse;
import team.world.trade.order.application.service.OrderService;

@Component
public class OrderFacade {

    private final OrderService orderService;

    public OrderFacade(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }
}
