package team.world.trade.user.presentation.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import team.world.trade.user.infrastructure.authentication.AuthenticationService;
import team.world.trade.user.infrastructure.authentication.RedisService;
import team.world.trade.user.presentation.interceptor.AuthenticationInterceptor;

@Configuration
public class AuthConfig implements WebMvcConfigurer {

    private final AuthenticationService authenticationService;

    public AuthConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor(authenticationService));
    }
}
