package team.world.trade.order.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Orderer {

    private Long orderId;
    private String username;

    public Orderer() {
    }

    public Orderer(@JsonProperty("username") String username) {
        this.username = username;
    }
}
