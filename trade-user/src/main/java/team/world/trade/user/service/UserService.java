package team.world.trade.user.service;

import java.util.List;
import java.util.Optional;
import team.world.trade.user.member.User;

public interface UserService {

    Optional<User> register(User user);

    Optional<User> findByName(String userName);

    List<User> findAll();

    boolean login(User user);

    void clear();
}