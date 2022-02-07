package team.world.trade.user.service.account;

import org.springframework.stereotype.Service;
import team.world.trade.user.exception.PasswordMismatchException;
import team.world.trade.user.model.Account;
import team.world.trade.user.model.dtos.LoginAccountDto;
import team.world.trade.user.repository.AccountRepository;
import team.world.trade.user.response.payload.AccountResponse;
import team.world.trade.user.service.encrypt.PasswordEncrypter;


@Service
public final class LoginAccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncrypter passwordEncrypter;

    public LoginAccountService(AccountRepository accountRepository,
                               PasswordEncrypter passwordEncrypter) {
        this.accountRepository = accountRepository;
        this.passwordEncrypter = passwordEncrypter;
    }

    public AccountResponse login(LoginAccountDto loginAccountDto) {
        String username = loginAccountDto.getUsername();
        String password = loginAccountDto.getPassword();

        Account account = accountRepository.findByUsername(username).orElseThrow();

        if (!passwordEncrypter.findEncrypted(username, password).equals(account.getPassword())) {
            throw new PasswordMismatchException();
        }

        return new AccountResponse(account.getUsername(), account.getEmail());
    }
}
