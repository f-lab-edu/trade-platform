package team.world.trade.commerce.application.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CategoryRequest {

    private String name;

    public CategoryRequest(@JsonProperty("name") String name) {
        this.name = name;
    }
}
