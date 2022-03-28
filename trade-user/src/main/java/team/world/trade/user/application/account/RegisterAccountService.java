package team.world.trade.user.application.account;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.world.trade.user.application.exception.AccountNotCreateException;
import team.world.trade.user.application.exception.FailedToChangePassword;
import team.world.trade.user.application.exception.PasswordMismatchException;
import team.world.trade.user.application.request.PasswordRequest;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.application.response.PasswordResponse;
import team.world.trade.user.domain.Account;
import team.world.trade.user.infrastructure.mybatis.AccountMapper;

@Service
public final class RegisterAccountService {

    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    public RegisterAccountService(AccountMapper accountMapper, PasswordEncoder passwordEncoder) {
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
        accountMapper.insert(account);

        return new AccountResponse(account.getUsername(), account.getEmail());
    }

    public PasswordResponse changePassword(Long userId, PasswordRequest request) {
        if (!success(userId, request.getOriginalPassword())) {
            throw new PasswordMismatchException();
        }

        Account account = new Account(userId, passwordEncoder.encode(request.getChangePassword()));

        if (accountMapper.updatePassword(account) == 1) {
            return new PasswordResponse(userId);
        }

        throw new FailedToChangePassword();
    }


    public boolean success(Long userId, String password) {
        Optional<Account> foundAccount = accountMapper.findById(userId);
        return passwordEncoder.matches(password, foundAccount.get().getPassword());
    }

}