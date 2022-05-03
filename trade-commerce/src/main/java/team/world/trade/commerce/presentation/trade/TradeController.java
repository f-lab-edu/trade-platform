package team.world.trade.commerce.presentation.trade;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.world.trade.commerce.application.TradeFacade;
import team.world.trade.commerce.presentation._request.TradeRequest;
import team.world.trade.common.response.ResponseApi;

@RestController
@RequestMapping("trade")
public class TradeController {

    private final TradeFacade tradeFacade;

    public TradeController(TradeFacade tradeFacade) {
        this.tradeFacade = tradeFacade;
    }

    @PostMapping("/create")
    public ResponseApi<?> create(@RequestBody TradeRequest tradeRequest) {
        return ResponseApi.success(tradeFacade.createTrade(tradeRequest));
    }

}
