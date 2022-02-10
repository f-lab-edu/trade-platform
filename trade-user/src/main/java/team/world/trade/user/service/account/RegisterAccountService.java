package team.world.trade.user.service.account;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.world.trade.user.exception.AccountNotCreateException;
import team.world.trade.user.model.Account;
import team.world.trade.user.model.dtos.RegisterAccountDto;
import team.world.trade.user.repository.AccountRepository;
import team.world.trade.user.response.payload.AccountResponse;

@Service
public final class RegisterAccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterAccountService(AccountRepository accountRepository,
                                  PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
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

        String encoded = passwordEncoder.encode(password);
        Account account = new Account(username, email, encoded);
        Account savedAccount = accountRepository.save(account);

        return new AccountResponse(savedAccount.getUsername(), savedAccount.getEmail());
    }
}