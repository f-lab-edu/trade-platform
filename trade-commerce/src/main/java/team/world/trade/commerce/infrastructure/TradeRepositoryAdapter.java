package team.world.trade.commerce.infrastructure;

import org.springframework.stereotype.Component;

import team.world.trade.commerce.domain.Trade;
import team.world.trade.commerce.domain.TradeRepository;
import team.world.trade.commerce.infrastructure.jpa.JpaTradeRepository;

@Component
public class TradeRepositoryAdapter implements TradeRepository {

    private final JpaTradeRepository jpaTradeRepository;

    public TradeRepositoryAdapter(JpaTradeRepository jpaTradeRepository) {
        this.jpaTradeRepository = jpaTradeRepository;
    }

    @Override
    public Trade save(Trade entity) {
        return jpaTradeRepository.save(entity);
    }

    @Override
    public Trade findById(Long tradeId) {
        return jpaTradeRepository.findById(tradeId).orElseThrow();
    }
}
