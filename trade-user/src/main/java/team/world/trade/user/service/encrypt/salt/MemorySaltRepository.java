package team.world.trade.user.service.encrypt.salt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class MemorySaltRepository implements SaltRepository {

    private static Map<String, String> store = new ConcurrentHashMap<>();

    @Override
    public String save(String username, String salt) {
        store.put(username, salt);
        return salt;
    }

    @Override
    public String findSaltByUsername(String username) {
        return store.get(username);
    }

}