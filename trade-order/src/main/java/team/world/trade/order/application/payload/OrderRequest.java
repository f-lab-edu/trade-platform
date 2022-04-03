package team.world.trade.order.application.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    private String username;
    private Long productId;
    private String address;
    private String zipcode;

    public OrderRequest(@JsonProperty("username") String username,
                        @JsonProperty("address") String address,
                        @JsonProperty("productId") Long productId,
                        @JsonProperty("zipcode") String zipcode) {
        this.username = username;
        this.address = address;
        this.productId = productId;
        this.zipcode = zipcode;
    }
}
