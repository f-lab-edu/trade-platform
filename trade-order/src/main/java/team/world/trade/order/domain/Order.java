package team.world.trade.order.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private Long orderId;
    private String username;
    private Long productId;
    private String address;
    private String zipcode;
    private LocalDateTime orderTime;
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(String username, Long productId, String address, String zipcode) {
        this.username = username;
        this.productId = productId;
        this.address = address;
        this.zipcode = zipcode;
        this.orderStatus = OrderStatus.COMPLETE;
    }
}