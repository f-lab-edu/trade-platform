package team.world.trade.user.service.account;

import org.springframework.stereotype.Service;
import team.world.trade.user.exception.AccountNotCreateException;
import team.world.trade.user.model.Account;
import team.world.trade.user.model.dtos.RegisterAccountDto;
import team.world.trade.user.repository.AccountRepository;
import team.world.trade.user.response.payload.AccountResponse;
import team.world.trade.user.service.encrypt.PasswordEncrypter;

@Service
public final class RegisterAccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncrypter passwordEncrypter;

    public RegisterAccountService(AccountRepository accountRepository,
                                  PasswordEncrypter passwordEncrypter) {
        this.accountRepository = accountRepository;
        this.passwordEncrypter = passwordEncrypter;
    }

    public AccountResponse register(RegisterAccountDto registerAccountDto) {
        String username = registerAccountDto.getUsername();
        String email = registerAccountDto.getEmail();
        String password = registerAccountDto.getPassword();

        if (accountRepository.existByEmail(email)) {
            throw new AccountNotCreateException();
        }

        if (accountRepository.existByUsername(username)) {
            throw new AccountNotCreateException();
        }

        String encrypted = passwordEncrypter.encrypt(username, password);

        Account account = new Account(username, email, encrypted);
        Account savedAccount = accountRepository.save(account);

        return new AccountResponse(savedAccount.getUsername(), savedAccount.getEmail());
    }
}