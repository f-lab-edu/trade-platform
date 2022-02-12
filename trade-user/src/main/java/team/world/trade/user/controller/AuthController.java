package team.world.trade.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.world.trade.user.model.dtos.LoginAccountDto;
import team.world.trade.user.model.dtos.RegisterAccountDto;
import team.world.trade.user.response.ResponseApi;
import team.world.trade.user.service.AccountFacade;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AccountFacade accountFacade;

    public AuthController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @PostMapping("/login")
    public ResponseApi<?> login(@RequestBody LoginAccountDto request,
                                HttpServletResponse response) {
        return ResponseApi.success(accountFacade.login(request, response));
    }

    @PostMapping("/signup")
    public ResponseApi<?> register(@RequestBody RegisterAccountDto registerAccountDto) {
        return ResponseApi.success(accountFacade.register(registerAccountDto));
    }

    @PostMapping("/logout")
    public ResponseApi<?> logout(HttpServletRequest request) {
        return ResponseApi.success(accountFacade.logout(request));
    }

    @PostMapping("/home")
    public ResponseApi<?> home(HttpServletRequest request) {
        return ResponseApi.success(accountFacade.home(request));
    }
}