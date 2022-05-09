package team.world.trade.user.application.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import team.world.trade.user.application.request.AccountSessionDto;

@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    public RedisService(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public AccountSessionDto getSession(String authKey) {
        String jsonResult = (String) redisTemplate.opsForValue().get(authKey);

        if (jsonResult != null) {
            try {
                return objectMapper.readValue(jsonResult, AccountSessionDto.class);
            } catch (JsonProcessingException e) {
                redisTemplate.delete(authKey);
                throw new RuntimeException(
                        "Failed to deserialize the object for session processing");
            }
        }

        return null;
    }

    public String makeSession(AccountSessionDto accountSession) {
        String authKey = UUID.randomUUID().toString();

        try {
            String json = objectMapper.writeValueAsString(
                    objectMapper.convertValue(accountSession, Map.class));
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
