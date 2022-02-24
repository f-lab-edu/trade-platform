package team.world.trade.commerce.application.response;

import lombok.Getter;

@Getter
public class ProductResponse {

    private String name;

    public ProductResponse(String name) {
        this.name = name;
    }

}
