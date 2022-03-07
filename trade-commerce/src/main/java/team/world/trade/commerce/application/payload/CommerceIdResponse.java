package team.world.trade.commerce.application.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CommerceIdResponse {

    @JsonProperty
    private final Long id;

    private CommerceIdResponse(Long id) {
        this.id = id;
    }

    public static CommerceIdResponse of(Long id) {
        return new CommerceIdResponse(id);
    }
}
