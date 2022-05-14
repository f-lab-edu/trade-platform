package team.world.trade.user.infrastructure;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import team.world.trade.user.application.authentication.AuthenticationService;
import team.world.trade.user.application.authentication.RedisService;

public class AuthenticationAdapter implements AuthenticationService {

    //    private final SessionManagerService sessionManagerService;
    private final RedisService redisService;

    public AuthenticationAdapter(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public String createAuth(String username, HttpServletResponse response) {
        return redisService.createAuth(username, response);
    }

    @Override
    public String getAuth(HttpServletRequest request) {
        return redisService.getAuth(request);
    }
}
