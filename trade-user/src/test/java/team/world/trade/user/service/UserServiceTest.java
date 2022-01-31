package team.world.trade.user.service;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import team.world.trade.user.member.User;
import team.world.trade.user.repository.MemoryUserRepository;

import static org.assertj.core.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {UserServiceImpl.class, MemoryUserRepository.class})
class UserServiceTest {

    private UserService userService;

    @Autowired
    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void join() {
        User user = new User("Lee", "p1234");
        User savedUser = userService.join(user);
        assertThat(savedUser.getName()).isEqualTo("Lee");
    }

    @Test
    void findById() {
        User user = new User("Lee", "p1234");
        userService.join(user);
        User findUser = userService.findById(0L);
        assertThat(findUser.getName()).isEqualTo("Lee");
    }

    @Test
    void findAll() {
        User userA = new User("Lee", "p1234");
        User userB = new User("Lee", "p1234");
        userService.join(userA);
        userService.join(userB);
        List<User> allUsers = userService.findAll();
        assertThat(allUsers.size()).isEqualTo(2);
    }
}