package team.world.trade.user.application.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.world.trade.user.application.exception.PasswordMismatchException;
import team.world.trade.user.application.redis.RedisService;
import team.world.trade.user.application.request.AccountSessionDto;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.domain.Account;
import team.world.trade.user.domain.AccountRepository;
import team.world.trade.user.domain.PasswordEncrypter;


@Service
@Transactional
public class LoginAccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncrypter passwordEncrypter;
    private final RedisService redisService;

    public LoginAccountService(AccountRepository accountRepository,
                               PasswordEncrypter passwordEncrypter,
                               RedisService redisService) {
        this.accountRepository = accountRepository;
        this.passwordEncrypter = passwordEncrypter;
        this.redisService = redisService;
    }

    public AccountResponse login(String username, String password) {
        if (!success(username, password)) {
            throw new PasswordMismatchException();
        }

        Account account = accountRepository.findByUsername(username).orElseThrow();
        return new AccountResponse(account.getUsername(), account.getEmail());
    }

    public String makeSession(AccountSessionDto accountSession) {
        return redisService.makeSession(accountSession);
    }

    private boolean success(String username, String password) {
        Optional<Account> foundAccount = accountRepository.findByUsername(username);
        return passwordEncrypter.matches(password, foundAccount.get().getPassword());
    }
}
