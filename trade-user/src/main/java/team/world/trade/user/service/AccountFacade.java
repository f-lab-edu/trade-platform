package team.world.trade.user.service;

import org.springframework.stereotype.Service;
import team.world.trade.user.model.dtos.LoginAccountDto;
import team.world.trade.user.model.dtos.RegisterAccountDto;
import team.world.trade.user.response.payload.AccountResponse;
import team.world.trade.user.service.account.LoginAccountService;
import team.world.trade.user.service.account.RegisterAccountService;

@Service
public class AccountFacade {

    private final LoginAccountService loginAccountService;
    private final RegisterAccountService registerAccountService;

    public AccountFacade(LoginAccountService loginAccountService,
                         RegisterAccountService registerAccountService) {
        this.loginAccountService = loginAccountService;
        this.registerAccountService = registerAccountService;
    }

    public AccountResponse login(LoginAccountDto loginAccountDto) {
        return loginAccountService.login(loginAccountDto);
    }

    public AccountResponse register(RegisterAccountDto registerAccountDto) {
        return registerAccountService.register(registerAccountDto);
    }
}
