package team.world.trade.user.application;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import team.world.trade.user.application.account.LoginAccountService;
import team.world.trade.user.application.account.RegisterAccountService;
import team.world.trade.user.application.request.AccountSessionDto;
import team.world.trade.user.application.request.LoginAccountDto;
import team.world.trade.user.application.request.PasswordRequest;
import team.world.trade.user.application.request.RegisterAccountDto;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.application.response.TokenResponse;
import team.world.trade.user.infrastructure.authentication.AuthenticationService;

@Service
public class AuthenticationFacade {

    private final LoginAccountService loginAccountService;
    private final RegisterAccountService registerAccountService;
    private final AuthenticationService authenticationService;

    public AuthenticationFacade(LoginAccountService loginAccountService,
                                RegisterAccountService registerAccountService,
                                AuthenticationService authenticationService) {
        this.loginAccountService = loginAccountService;
        this.registerAccountService = registerAccountService;
        this.authenticationService = authenticationService;
    }

    public AccountResponse login(LoginAccountDto dto, HttpServletResponse response) {
        AccountResponse account = loginAccountService.login(dto.getUsername(), dto.getPassword());
        authenticationService.createAuth(dto.getUsername(), response);

        return new AccountResponse(account.getUsername(), account.getEmail());
    }

    public AccountResponse register(RegisterAccountDto dto) {
        return registerAccountService.register(dto.getUsername(), dto.getEmail(),
                dto.getPassword());
    }

    public AccountResponse changePassword(Long userId, PasswordRequest request) {
        return registerAccountService.changePassword(userId, request);
    }


}
