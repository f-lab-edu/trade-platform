package team.world.trade.order.application.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import team.world.trade.order.domain.Orderer;
import team.world.trade.order.domain.ShippingInfo;

@Getter
@Setter
public class OrderRequest {

    Orderer orderer;
    OrderProduct orderProduct;
    ShippingInfo shippingInfo;

    public OrderRequest() {
    }

    public OrderRequest(@JsonProperty("orderer") Orderer orderer,
                        @JsonProperty("orderProduct") OrderProduct orderProduct,
                        @JsonProperty("shippingInfo") ShippingInfo shippingInfo) {
        this.orderer = orderer;
        this.orderProduct = orderProduct;
        this.shippingInfo = shippingInfo;
    }
}
