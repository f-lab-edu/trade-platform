package team.world.trade.user.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import team.world.trade.user.application.account.LoginAccountService;
import team.world.trade.user.application.account.RegisterAccountService;
import team.world.trade.user.application.request.LoginAccountDto;
import team.world.trade.user.application.request.PasswordRequest;
import team.world.trade.user.application.request.RegisterAccountDto;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.application.response.PasswordResponse;
import team.world.trade.user.application.session.SessionManagerService;

@Service
public class AuthenticationFacade {

    private final LoginAccountService loginAccountService;
    private final RegisterAccountService registerAccountService;
    private final SessionManagerService sessionManagerService;

    public AuthenticationFacade(LoginAccountService loginAccountService,
                                RegisterAccountService registerAccountService,
                                SessionManagerService sessionManagerService) {
        this.loginAccountService = loginAccountService;
        this.registerAccountService = registerAccountService;
        this.sessionManagerService = sessionManagerService;
    }

    public AccountResponse login(LoginAccountDto dto, HttpServletRequest request,
                                 HttpServletResponse response) {
        AccountResponse accountResponse = null;
        if (!sessionManagerService.alreadyLogin(request)) {
            accountResponse = loginAccountService.login(dto.getUsername(), dto.getPassword());
            sessionManagerService.createSession(dto.getUsername(), response);
        }
        return accountResponse;
    }

    public AccountResponse register(RegisterAccountDto dto) {
        return registerAccountService.register(dto.getUsername(), dto.getEmail(),
                dto.getPassword());
    }

    public PasswordResponse changePassword(Long userId, PasswordRequest request) {
        return registerAccountService.changePassword(userId, request);
    }

    public String logout(HttpServletRequest request) {
        return sessionManagerService.expireSession(request);
    }

}
