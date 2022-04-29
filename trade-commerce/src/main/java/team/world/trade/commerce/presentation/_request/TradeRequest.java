package team.world.trade.commerce.presentation._request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import team.world.trade.common.enums.TradeStatus;

@Getter
public class TradeRequest {

    private String username;

    private Long productId;

    private TradeStatus tradeStatus;

    public TradeRequest(
            @JsonProperty("username") String username,
            @JsonProperty("productId") Long productId,
            @JsonProperty("tradeStatus") TradeStatus tradeStatus) {
        this.username = username;
        this.productId = productId;
        this.tradeStatus = tradeStatus;
    }


}
