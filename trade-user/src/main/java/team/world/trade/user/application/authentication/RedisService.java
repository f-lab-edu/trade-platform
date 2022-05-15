package team.world.trade.user.application.authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import team.world.trade.user.application.request.AccountSessionDto;

public class RedisService implements AuthenticationService {

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    public RedisService(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public String getAuth(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        String jsonResult = (String) redisTemplate.opsForValue().get(bearerToken);

        if (jsonResult != null) {
            try {
                return objectMapper.readValue(jsonResult, String.class);
            } catch (JsonProcessingException e) {
                redisTemplate.delete(bearerToken);
                throw new RuntimeException(
                        "Failed to deserialize the object for session processing");
            }
        }
        return null;
    }

    @Override
    public String createAuth(String username, HttpServletResponse response) {
        String authKey = UUID.randomUUID().toString();

        try {
            String json = objectMapper.writeValueAsString(
                    objectMapper.convertValue(username, String.class));
            redisTemplate.opsForValue().set(authKey, json);
            redisTemplate.expire(authKey, 1800, TimeUnit.SECONDS);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize the object for session processing");
        }

        return authKey;
    }


    public void renewSession(AccountSessionDto accountSession, String authKey) {
        if (accountSession != null) {
            redisTemplate.expire(authKey, 1800, TimeUnit.SECONDS);
        }
    }

}
