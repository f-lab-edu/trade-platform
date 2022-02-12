package team.world.trade.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import team.world.trade.user.model.dtos.LoginAccountDto;
import team.world.trade.user.model.dtos.RegisterAccountDto;
import team.world.trade.user.response.payload.AccountResponse;
import team.world.trade.user.service.account.LoginAccountService;
import team.world.trade.user.service.account.LogoutAccountService;
import team.world.trade.user.service.account.RegisterAccountService;
import team.world.trade.user.service.session.SessionAccountService;

@Service
public class AccountFacade {

    private final LoginAccountService loginAccountService;
    private final RegisterAccountService registerAccountService;
    private final SessionAccountService sessionAccountService;

    public AccountFacade(LoginAccountService loginAccountService,
                         RegisterAccountService registerAccountService,
                         SessionAccountService sessionAccountService) {
        this.loginAccountService = loginAccountService;
        this.registerAccountService = registerAccountService;
        this.sessionAccountService = sessionAccountService;
    }

    public AccountResponse login(LoginAccountDto loginAccountDto, HttpServletResponse response) {
        return loginAccountService.login(loginAccountDto, response);
    }

    public AccountResponse register(RegisterAccountDto registerAccountDto) {
        return registerAccountService.register(registerAccountDto);
    }

    public AccountResponse logout(HttpServletRequest request) {
        return sessionAccountService.logout(request);
    }

    public AccountResponse home(HttpServletRequest request) {
        return sessionAccountService.home(request);
    }
}
