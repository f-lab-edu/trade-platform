package team.world.trade.user.presentation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;
import team.world.trade.user.application.redis.RedisService;
import team.world.trade.user.application.request.AccountSessionDto;

public class AuthLoginInterceptor implements HandlerInterceptor {

    private final RedisService redisService;

    public AuthLoginInterceptor(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null) {
            AccountSessionDto session = redisService.getSession(token);
            redisService.renewSession(session, token);
        }
        return true;
    }

}
