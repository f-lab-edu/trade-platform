package team.world.trade.user.application.account;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.world.trade.user.application.exception.PasswordMismatchException;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.domain.Account;
import team.world.trade.user.domain.AccountRepository;


@Service
public final class LoginAccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginAccountService(AccountRepository accountRepository,
                               PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AccountResponse login(String username, String password) {
        if (!success(username, password)) {
            throw new PasswordMismatchException();
        }

        Account account = accountRepository.findByUsername(username).orElseThrow();
        return new AccountResponse(account.getUsername(), account.getEmail());
    }

    public boolean success(String username, String password) {
        Optional<Account> foundAccount = accountRepository.findByUsername(username);
        return passwordEncoder.matches(password, foundAccount.get().getPassword());
    }
}
