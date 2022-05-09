package team.world.trade.user.application;

import org.springframework.stereotype.Service;
import team.world.trade.user.application.account.LoginAccountService;
import team.world.trade.user.application.account.RegisterAccountService;
import team.world.trade.user.application.request.AccountSessionDto;
import team.world.trade.user.application.request.LoginAccountDto;
import team.world.trade.user.application.request.PasswordRequest;
import team.world.trade.user.application.request.RegisterAccountDto;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.application.response.TokenResponse;

@Service
public class AuthenticationFacade {

    private final LoginAccountService loginAccountService;
    private final RegisterAccountService registerAccountService;

    public AuthenticationFacade(LoginAccountService loginAccountService,
                                RegisterAccountService registerAccountService) {
        this.loginAccountService = loginAccountService;
        this.registerAccountService = registerAccountService;
    }

    public TokenResponse login(LoginAccountDto dto) {
        AccountResponse account = loginAccountService.login(dto.getUsername(), dto.getPassword());

        AccountSessionDto accountSessionDto =
                new AccountSessionDto(account.getUsername(), account.getEmail());

        String authKey = loginAccountService.makeSession(accountSessionDto);
        return new TokenResponse(authKey);
    }

    public AccountResponse register(RegisterAccountDto dto) {
        return registerAccountService.register(dto.getUsername(), dto.getEmail(),
                dto.getPassword());
    }

    public AccountResponse changePassword(Long userId, PasswordRequest request) {
        return registerAccountService.changePassword(userId, request);
    }


}
