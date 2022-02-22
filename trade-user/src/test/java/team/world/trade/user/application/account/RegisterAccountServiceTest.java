package team.world.trade.user.application.account;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.domain.AccountRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RegisterAccountService.class)
class RegisterAccountServiceTest {

    @Autowired
    RegisterAccountService registerAccountService;

    @MockBean
    AccountRepository accountRepository;

    @MockBean
    PasswordEncoder passwordEncoder;


    @Test
    void register() {
        AccountResponse accountResponse = registerAccountService.register("lee1", "lee1@gmail.com",
                "password1");
        assertThat(accountResponse.getUsername()).isEqualTo("lee1");
    }
}