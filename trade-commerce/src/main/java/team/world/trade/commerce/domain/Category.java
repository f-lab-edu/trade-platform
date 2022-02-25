package team.world.trade.commerce.domain;

import lombok.Getter;

@Getter
public class Category {

    private Long id;
    private String name;

    private Category(String name) {
        this.name = name;
    }

    public static Category of(String name) {
        return new Category(name);
    }

}
