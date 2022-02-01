package team.world.trade.user.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.world.trade.user.member.User;
import team.world.trade.user.repository.UserRepository;
import team.world.trade.user.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> register(User user) {
        Optional<User> findUser = findByName(user.getName());
        if (!findUser.isPresent()) {
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    @Override
    public boolean login(User user) {
        Optional<User> findUser = findByName(user.getName());
        if (findUser.isPresent()) {
            String password = findUser.get().getPassword();
            return UserUtils.isSameString(password, user.getPassword());
        }
        return false;
    }

    @Override
    public Optional<User> findByName(String userName) {
        return userRepository.findByName(userName);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void clear() {
        userRepository.clear();
    }

    private boolean checkPassword(User user) {
        User findUser = findUser(user);
        String findUserPassword = findUser.getPassword();
        String password = user.getPassword();
        return UserUtils.isSameString(password, findUserPassword);
    }

    private User findUser(User user) {
        List<User> users = userRepository.findAll();
        int target = users.indexOf(user);
        User findUser = users.get(target);
        return findUser;
    }


}
