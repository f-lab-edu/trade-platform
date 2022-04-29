package team.world.trade.commerce.domain;

public interface TradeRepository {

    Trade save(Trade entity);

    Trade findById(Long tradeId);

}
