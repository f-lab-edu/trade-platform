package team.world.trade.order.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import team.world.trade.order.application.payload.Address;

@Getter
public class ShippingInfo {

    private Long orderId;
    private Address address;

    public ShippingInfo() {
    }

    public ShippingInfo(@JsonProperty("address") Address address) {
        this.address = address;
    }
}
