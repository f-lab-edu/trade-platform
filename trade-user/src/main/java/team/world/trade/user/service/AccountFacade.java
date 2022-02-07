package team.world.trade.user.service;

import org.springframework.stereotype.Service;
import team.world.trade.user.model.dtos.LoginAccountDto;
import team.world.trade.user.model.dtos.RegisterAccountDto;
import team.world.trade.user.repository.AccountRepository;
import team.world.trade.user.response.payload.AccountResponse;
import team.world.trade.user.service.account.LoginAccountService;
import team.world.trade.user.service.account.RegisterAccountService;

@Service
public class AccountFacade {

    private final LoginAccountService loginAccountService;
    private final RegisterAccountService registerAccountService;
    private final AccountRepository accountRepository;

    public AccountFacade(LoginAccountService loginAccountService,
                         RegisterAccountService registerAccountService,
                         AccountRepository accountRepository) {
        this.loginAccountService = loginAccountService;
        this.registerAccountService = registerAccountService;
        this.accountRepository = accountRepository;
    }

    public AccountResponse login(LoginAccountDto loginAccountDto) {
        return loginAccountService.login(loginAccountDto.getUsername(),
                loginAccountDto.getPassword());
    }

    public AccountResponse register(RegisterAccountDto registerAccountDto) {
        return registerAccountService.register(registerAccountDto.getUsername(),
                registerAccountDto.getEmail(), registerAccountDto.getPassword());
    }
}
