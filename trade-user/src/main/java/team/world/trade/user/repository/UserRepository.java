package team.world.trade.user.repository;

import java.util.List;
import team.world.trade.user.member.User;

public interface UserRepository {

    User save(User user);

    User findById(Long id);

    List<User> findAll();
}
