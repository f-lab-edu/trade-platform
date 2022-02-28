package team.world.trade.commerce.domain;

import lombok.Getter;

@Getter
public class ProductCategory {

    private Long productId;
    private Long categoryId;

    public ProductCategory(Long productId, Long categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }
}
