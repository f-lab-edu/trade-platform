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
import team.world.trade.user.service.AuthenticationFacade;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationFacade authenticationFacade;

    public AuthenticationController(AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

    @PostMapping("/login")
    public ResponseApi<?> login(@RequestBody LoginAccountDto loginAccountDto,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        return ResponseApi.success(authenticationFacade.login(loginAccountDto, request, response));
    }

    @PostMapping("/signup")
    public ResponseApi<?> register(@RequestBody RegisterAccountDto registerAccountDto) {
        return ResponseApi.success(authenticationFacade.register(registerAccountDto));
    }

    @PostMapping("/logout")
    public ResponseApi<?> logout(HttpServletRequest request) {
        return ResponseApi.success(authenticationFacade.logout(request));
    }

}