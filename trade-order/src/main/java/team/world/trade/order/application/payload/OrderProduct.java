package team.world.trade.order.application.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderProduct {
    private Long productId;

    public OrderProduct(@JsonProperty("productId") Long productId) {
        this.productId = productId;
    }
}
