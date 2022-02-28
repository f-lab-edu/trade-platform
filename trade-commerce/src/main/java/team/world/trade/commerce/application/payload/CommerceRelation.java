package team.world.trade.commerce.application.payload;

import java.util.Set;
import lombok.Getter;

@Getter
public class CommerceRelation {

    private Long productId;
    private Set<Long> catalogIds;

    private CommerceRelation(Long productId, Set<Long> catalogIds) {
        this.productId = productId;
        this.catalogIds = catalogIds;
    }

    public static CommerceRelation of(Long productId, Set<Long> catalogIds) {
        return new CommerceRelation(productId, catalogIds);
    }
}
