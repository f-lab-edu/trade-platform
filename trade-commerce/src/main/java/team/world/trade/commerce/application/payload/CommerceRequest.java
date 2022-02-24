package team.world.trade.commerce.application.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import lombok.Getter;

@Getter
public class CommerceRequest {
    private final String name;
    private final Integer price;
    private final String detail;
    private final Set<Long> categoryIds;

    public CommerceRequest(@JsonProperty("name") String name,
                           @JsonProperty("price") Integer price,
                           @JsonProperty("detail") String detail,
                           @JsonProperty("categoryIds") Set<Long> categoryIds) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.categoryIds = categoryIds;
    }


}
