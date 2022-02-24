package team.world.trade.commerce.domain;

import java.util.Set;
import lombok.Getter;

@Getter
public class Product {

    private Long id;
    private String name;
    private Integer price;
    private String detail;
    private Set<Long> categoryIds;

    private Product(String name, Integer price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public static Product of(String name, Integer price, String detail) {
        return new Product(name, price, detail);
    }
}
