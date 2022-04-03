package team.world.trade.order.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.world.trade.common.response.ResponseApi;
import team.world.trade.order.application.OrderFacade;
import team.world.trade.order.application.payload.OrderRequest;


@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @PostMapping(value = "/create")
    public ResponseApi<?> order(@RequestBody OrderRequest orderRequest) {
        return ResponseApi.success(orderFacade.createOrder(orderRequest));
    }
}