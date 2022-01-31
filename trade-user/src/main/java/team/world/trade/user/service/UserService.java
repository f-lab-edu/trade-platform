package team.world.trade.user.service;

import java.util.List;
import team.world.trade.user.member.User;

public interface UserService {

    User join(User user);

    User findById(Long id);

    List<User> findAll();
}
