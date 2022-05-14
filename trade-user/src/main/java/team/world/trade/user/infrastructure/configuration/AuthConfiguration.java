package team.world.trade.user.infrastructure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import team.world.trade.user.application.authentication.AuthenticationService;
import team.world.trade.user.application.authentication.RedisService;
import team.world.trade.user.application.authentication.SessionManager;
import team.world.trade.user.application.authentication.SessionManagerService;
import team.world.trade.user.infrastructure.AuthenticationAdapter;

@Configuration
public class AuthConfiguration {

    @Bean
    public SessionManager sessionManager() {
        return new SessionManager();
    }

    @Bean
    public SessionManagerService sessionManagerService(SessionManager sessionManager) {
        return new SessionManagerService(sessionManager);
    }

    @Bean
    public RedisService redisService(RedisTemplate redisTemplate, ObjectMapper objectMapper) {
        return new RedisService(redisTemplate, objectMapper);
    }

    @Bean
    public AuthenticationService authenticationService(RedisService redisService) {
        return new AuthenticationAdapter(redisService);
    }
}