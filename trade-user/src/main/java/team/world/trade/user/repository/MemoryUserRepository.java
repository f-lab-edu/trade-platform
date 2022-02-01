package team.world.trade.user.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import team.world.trade.user.member.User;

@Repository
public class MemoryUserRepository implements UserRepository {

    private static Map<String, User> store = new HashMap<>();

    @Override
    public User save(User user) {
        store.put(user.getName(), user);
        return user;
    }

    @Override
    public Optional<User> findByName(String username) {
        User user = store.get(username);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user);
    }


    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clear() {
        store.clear();
    }
}
