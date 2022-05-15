package team.world.trade.user.presentation;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.world.trade.common.annotation.Authentication;
import team.world.trade.common.response.ResponseApi;
import team.world.trade.user.application.AuthenticationFacade;
import team.world.trade.user.application.request.LoginAccountDto;
import team.world.trade.user.application.request.PasswordRequest;
import team.world.trade.user.application.request.RegisterAccountDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationFacade authenticationFacade;

    public AuthController(AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }


    @PostMapping("/login")
    public ResponseApi<?> login(@RequestBody LoginAccountDto loginAccountDto,
                                HttpServletResponse response) {
        return ResponseApi.success(authenticationFacade.login(loginAccountDto, response));
    }

    @PostMapping("/signup")
    public ResponseApi<?> register(@RequestBody RegisterAccountDto registerAccountDto) {
        return ResponseApi.success(authenticationFacade.register(registerAccountDto));
    }

    @PatchMapping("/{userId}/password")
    @Authentication
    public ResponseApi<?> changePassword(@PathVariable Long userId,
                                         @RequestBody PasswordRequest changePasswordRequest) {
        return ResponseApi.success(
                authenticationFacade.changePassword(userId, changePasswordRequest));
    }

}