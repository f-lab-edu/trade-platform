package team.world.trade.commerce.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import team.world.trade.commerce.domain.Trade;

public interface JpaTradeRepository extends JpaRepository<Trade, Long> {

}
