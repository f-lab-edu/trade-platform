package team.world.trade.user.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import team.world.trade.user.member.User;

@Repository
public class MemoryUserRepository implements UserRepository {

    private static Map<Long, User> store = new HashMap<>();

    private static Long sequence = 0L;

    @Override
    public User save(User user) {
        user.setId(sequence++);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}
