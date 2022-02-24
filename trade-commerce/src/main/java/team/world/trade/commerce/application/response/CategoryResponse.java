package team.world.trade.commerce.application.response;

import lombok.Getter;

@Getter
public class CategoryResponse {

    private String name;

    public CategoryResponse(String name) {
        this.name = name;
    }
}
