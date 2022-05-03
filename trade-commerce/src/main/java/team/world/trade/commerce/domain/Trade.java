package team.world.trade.commerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import team.world.trade.common.enums.TradeStatus;

@Getter
@Setter
@Entity
@Table(name = "TRADE")
public class Trade {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String accountUsername;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "STATUS")
    private TradeStatus tradeStatus;

    private Trade(String accountUsername, Long productId, TradeStatus tradeStatus) {
        this.accountUsername = accountUsername;
        this.productId = productId;
        this.tradeStatus = tradeStatus;
    }

    public Trade() {

    }

    public static Trade of(String accountUsername, Long productId, TradeStatus tradeStatus) {
        return new Trade(accountUsername, productId, tradeStatus);
    }
}
