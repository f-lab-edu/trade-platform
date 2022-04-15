package team.world.trade.user.application.account;

import org.springframework.stereotype.Service;
import team.world.trade.common.service.PasswordEncrypter;
import team.world.trade.user.application.exception.AccountNotCreateException;
import team.world.trade.user.application.exception.PasswordMismatchException;
import team.world.trade.user.application.request.PasswordRequest;
import team.world.trade.user.application.response.AccountResponse;
import team.world.trade.user.domain.Account;
import team.world.trade.user.domain.AccountRepository;

@Service
public final class RegisterAccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncrypter passwordEncrypter;

    public RegisterAccountService(AccountRepository accountRepository,
                                  PasswordEncrypter passwordEncrypter) {
        this.accountRepository = accountRepository;
        this.passwordEncrypter = passwordEncrypter;
    }

    public AccountResponse register(String username, String email, String password) {
        if (accountRepository.existByEmail(email)) {
            throw new AccountNotCreateException();
        }

        if (accountRepository.existByUsername(username)) {
            throw new AccountNotCreateException();
        }

        String encoded = passwordEncrypter.encode(password);
        Account account = new Account(username, email, encoded);
        accountRepository.save(account);

        return new AccountResponse(account.getUsername(), account.getEmail());
    }

    public AccountResponse changePassword(Long userId, PasswordRequest request) {
        String originalPassword = request.getOriginalPassword();
        String changePassword = request.getChangePassword();

        Account account = accountRepository.findById(userId).orElseThrow();
        if (!passwordEncrypter.matches(originalPassword, account.getPassword())) {
            throw new PasswordMismatchException();
        }

        account.changePassword(passwordEncrypter.encode(changePassword));
        accountRepository.save(account);
        return new AccountResponse(account.getUsername(), account.getEmail());
    }

}