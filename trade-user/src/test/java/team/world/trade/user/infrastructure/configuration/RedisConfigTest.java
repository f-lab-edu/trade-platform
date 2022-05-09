package team.world.trade.user.infrastructure.configuration;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest(classes = RedisConfig.class)
class RedisConfigTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Test
    void test_strings() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "stringKey";

        valueOperations.set(key, "hello");
        String value = valueOperations.get(key);
        assertThat(value).isEqualTo("hello");
    }
}