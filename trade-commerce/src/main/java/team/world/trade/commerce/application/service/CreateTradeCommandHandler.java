package team.world.trade.commerce.application.service;

import org.springframework.stereotype.Component;

import team.world.trade.commerce.domain.Trade;

import team.world.trade.commerce.domain.TradeRepository;

@Component
public class CreateTradeCommandHandler {

    private final TradeRepository tradeRepository;

    public CreateTradeCommandHandler(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public Trade createTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

}
