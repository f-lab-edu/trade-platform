package team.world.trade.user.service.encrypt;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import team.world.trade.user.service.encrypt.salt.MemorySaltRepository;

class PasswordEncrypterTest {

    @Test
    void passwordTest() throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(PasswordEncrypter.class,
                MemorySaltRepository.class);

        PasswordEncrypter passwordEncrypter = ac.getBean(PasswordEncrypter.class);

        final String username = "user1";
        final String password = "password!";
        final String confirmPassowrd = "password!";

        String encrypted = passwordEncrypter.encrypt(username, password);
        String foundedEncrypted = passwordEncrypter.findEncrypted(username, confirmPassowrd);
        Assertions.assertThat(foundedEncrypted).isEqualTo(encrypted);
    }
}