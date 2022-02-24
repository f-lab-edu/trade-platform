package team.world.trade.commerce.application.payload;

import java.util.Set;

public class CommerceResponse {

    private final String name;
    private final Integer price;
    private final String detail;
    private final Set<Long> categoryIds;

    private CommerceResponse(String name, Integer price, String detail,
                             Set<Long> categoryIds) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.categoryIds = categoryIds;
    }

    public static CommerceResponse of(String name, Integer price, String detail,
                                      Set<Long> categoryIds) {
        return new CommerceResponse(name, price, detail, categoryIds);
    }
}