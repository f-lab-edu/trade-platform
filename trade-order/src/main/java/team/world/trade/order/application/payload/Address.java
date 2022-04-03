package team.world.trade.order.application.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    private String zipCode;
    private String address;

    public Address(@JsonProperty("zipCode") String zipCode,
                   @JsonProperty("address") String address) {
        this.zipCode = zipCode;
        this.address = address;
    }
}
