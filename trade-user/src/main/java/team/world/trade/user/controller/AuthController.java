package team.world.trade.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import team.world.trade.user.model.dtos.LoginAccountDto;
import team.world.trade.user.model.dtos.RegisterAccountDto;
import team.world.trade.user.response.ResponseApi;
import team.world.trade.user.service.AccountFacade;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final AccountFacade accountFacade;

    public AuthController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @PostMapping("/login")
    public ResponseApi<?> login(LoginAccountDto request) {
        return ResponseApi.success(accountFacade.login(request));
    }

    @PostMapping("/signup")
    public ResponseApi<?> register(RegisterAccountDto request) {
        return ResponseApi.success(accountFacade.register(request));
    }

    @GetMapping(value = "/signup")
    public ModelAndView getRegisterPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/register");
        return mv;
    }
}
