package team.world.trade.user.application.account;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.world.trade.user.application.exception.PasswordMismatchException;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.domain.Account;
import team.world.trade.user.infrastructure.mybatis.AccountMapper;


@Service
public final class LoginAccountService {

    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    public LoginAccountService(AccountMapper accountMapper,
                               PasswordEncoder passwordEncoder) {
        this.accountMapper = accountMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public AccountResponse login(String username, String password) {
        if (!success(username, password)) {
            throw new PasswordMismatchException();
        }

        Account account = accountMapper.findByUsername(username).orElseThrow();
        return new AccountResponse(account.getUsername(), account.getEmail());
    }

    public boolean success(String username, String password) {
        Optional<Account> foundAccount = accountMapper.findByUsername(username);
        return passwordEncoder.matches(password, foundAccount.get().getPassword());
    }
}
