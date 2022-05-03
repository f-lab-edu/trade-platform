package team.world.trade.commerce.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import team.world.trade.commerce.application.service.CreateTradeCommandHandler;

import team.world.trade.commerce.domain.Trade;
import team.world.trade.commerce.presentation._request.TradeRequest;

@Service
public class TradeFacade {

    private final CreateTradeCommandHandler createTradeCommandHandler;
    private final TransactionTemplate transactionTemplate;

    public TradeFacade(CreateTradeCommandHandler createTradeCommandHandler,
                       TransactionTemplate transactionTemplate) {
        this.createTradeCommandHandler = createTradeCommandHandler;
        this.transactionTemplate = transactionTemplate;
    }

    public Long createTrade(TradeRequest tradeRequest) {
        Trade trade = transactionTemplate.execute(transaction ->
                createTradeCommandHandler.createTrade(
                        Trade.of(tradeRequest.getUsername(), tradeRequest.getProductId(),
                                tradeRequest.getTradeStatus())));

        return trade.getId();
    }
}
