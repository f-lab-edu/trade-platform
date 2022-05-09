package team.world.trade.user.presentation.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import team.world.trade.user.application.redis.RedisService;
import team.world.trade.user.presentation.interceptor.AuthLoginInterceptor;

@Configuration
public class AuthConfig implements WebMvcConfigurer {

    private final RedisService redisService;

    public AuthConfig(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthLoginInterceptor(redisService));
    }
}
