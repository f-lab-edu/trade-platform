package team.world.trade.user.application.account;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.world.trade.user.application.exception.PasswordMismatchException;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.domain.Account;
import team.world.trade.user.domain.AccountRepository;
import team.world.trade.user.domain.PasswordEncrypter;


@Service
@Transactional
public class LoginAccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncrypter passwordEncrypter;

    public LoginAccountService(AccountRepository accountRepository,
                               PasswordEncrypter passwordEncrypter) {
        this.accountRepository = accountRepository;
        this.passwordEncrypter = passwordEncrypter;
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
        return passwordEncrypter.matches(password, foundAccount.get().getPassword());
    }
}
