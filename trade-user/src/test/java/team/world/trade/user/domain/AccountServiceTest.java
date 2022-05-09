package team.world.trade.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import team.world.trade.user.application.account.LoginAccountService;
import team.world.trade.user.application.account.RegisterAccountService;
import team.world.trade.user.application.exception.AccountNotCreateException;
import team.world.trade.user.application.exception.PasswordMismatchException;
import team.world.trade.user.application.redis.RedisService;
import team.world.trade.user.application.response.AccountResponse;

@DisplayName("Login test")
class AccountServiceTest {

    @Test
    void registerAccount() {
        AccountRepository accountRepository = new FakeAccountRepository();

        RegisterAccountService registerAccountService =
                new RegisterAccountService(accountRepository, new FakePasswordEncrypter());

        AccountResponse accountResponse =
                registerAccountService.register("이승철", "mangfu100@gmail.com", "password!");

        assertThat(accountResponse.getUsername()).isEqualTo("이승철");
    }

    @Test
    void registerThrowsExceptionWhenSameUserRegister() {
        AccountRepository accountRepository = new FakeAccountRepository();

        RegisterAccountService registerAccountService =
                new RegisterAccountService(accountRepository, new FakePasswordEncrypter());

        registerAccountService.register("이승철", "mangfu100@gmail.com", "password!");
        assertThatExceptionOfType(AccountNotCreateException.class)
                .isThrownBy(() -> registerAccountService.register("이승철", "test@gmail.com", "test")
                );
    }
}