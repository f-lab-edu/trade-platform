package team.world.trade.user.repository;

import java.util.List;
import java.util.Optional;
import team.world.trade.user.member.User;

public interface UserRepository {

    User save(User user);

    Optional<User> findByName(String username);

    List<User> findAll();

    void clear();
}
