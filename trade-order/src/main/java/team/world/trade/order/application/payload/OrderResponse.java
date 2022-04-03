package team.world.trade.order.application.payload;


import lombok.Getter;

@Getter
public class OrderResponse {

    private Long orderId;
    private Long productId;

    public OrderResponse(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }
}
