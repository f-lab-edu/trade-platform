package team.world.trade.user.presentation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import team.world.trade.common.annotation.Authentication;
import team.world.trade.user.application.authentication.AuthenticationService;

public class AuthenticationInterceptor implements HandlerInterceptor {

    private final AuthenticationService authenticationService;

    public AuthenticationInterceptor(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        Authentication authAnnotation =
                ((HandlerMethod) handler).getMethodAnnotation(Authentication.class);

        if (authAnnotation != null) {
            String auth = authenticationService.getAuth(request);
            if (auth == null) {
                throw new RuntimeException("User should be signed in");
            }
        }
        return true;
    }

}
