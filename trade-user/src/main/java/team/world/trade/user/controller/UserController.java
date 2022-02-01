package team.world.trade.user.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.world.trade.user.member.User;
import team.world.trade.user.service.UserService;
import team.world.trade.user.utils.UserUtils;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = new User(username, password);
        boolean succeed = userService.login(user);
        if (succeed) {
            return "user/login";
        }
        return "user/login_fail";
    }

    
    @PostMapping(value = "/register")
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String confirmedPassword) {
        boolean succeed = UserUtils.isSameString(password, confirmedPassword);
        if (succeed) {
            User user = new User(username, password);
            Optional<User> succeedRegister = userService.register(user);
            if (succeedRegister.isPresent()) {
                return "redirect:/";
            } else {
                return "register_fail";
            }
        }
        return "user/register_fail";
    }

    @RequestMapping(value = "/register")
    public String registerPage() {
        return "user/register";
    }
}
