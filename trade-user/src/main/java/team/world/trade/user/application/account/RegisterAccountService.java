package team.world.trade.user.application.account;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.world.trade.user.application.exception.AccountNotCreateException;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.domain.Account;
import team.world.trade.user.infrastructure.mybatis.AccountMapper;

@Service
public final class RegisterAccountService {

    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    public RegisterAccountService(AccountMapper accountMapper,
                                  PasswordEncoder passwordEncoder) {
        this.accountMapper = accountMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public AccountResponse register(String username, String email, String password) {
        if (accountMapper.existByEmail(email)) {
            throw new AccountNotCreateException();
        }

        if (accountMapper.existByUsername(username)) {
            throw new AccountNotCreateException();
        }

        String encoded = passwordEncoder.encode(password);
        Account account = new Account(username, email, encoded);
        accountMapper.save(account);

        return new AccountResponse(account.getUsername(), account.getEmail());
    }
}