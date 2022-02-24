package team.world.trade.user.presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.world.trade.common.response.ResponseApi;
import team.world.trade.user.application.AuthenticationFacade;
import team.world.trade.user.application.request.LoginAccountDto;
import team.world.trade.user.application.request.RegisterAccountDto;

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