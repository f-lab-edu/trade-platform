package team.world.trade.user.application.account;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.world.trade.user.application.exception.AccountNotCreateException;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.domain.Account;
import team.world.trade.user.domain.AccountRepository;

@Service
public final class RegisterAccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterAccountService(AccountRepository accountRepository,
                                  PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AccountResponse register(String username, String email, String password) {
        if (accountRepository.existByEmail(email)) {
            throw new AccountNotCreateException();
        }

        if (accountRepository.existByUsername(username)) {
            throw new AccountNotCreateException();
        }

        String encoded = passwordEncoder.encode(password);
        Account account = new Account(username, email, encoded);
        accountRepository.save(account);

        return new AccountResponse(account.getUsername(), account.getEmail());
    }
}