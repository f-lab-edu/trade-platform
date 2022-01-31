package team.world.trade.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {


    @RequestMapping(value = "/login")
    public String doLogin() {
        return "user/login";
    }

    @RequestMapping(value = "/register")
    public String doRegister() {
        return "user/register";
    }
}
