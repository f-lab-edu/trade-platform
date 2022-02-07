package team.world.trade.user.service.account;

import org.springframework.stereotype.Service;
import team.world.trade.user.exception.AccountNotCreateException;
import team.world.trade.user.model.Account;
import team.world.trade.user.repository.AccountRepository;
import team.world.trade.user.response.payload.AccountResponse;

@Service
public final class RegisterAccountService {

    private final AccountRepository accountRepository;

    public RegisterAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse register(String username, String email, String password) {
        if (accountRepository.existByEmail(email)) {
            throw new AccountNotCreateException();
        }

        if (accountRepository.existByUsername(username)) {
            throw new AccountNotCreateException();
        }

        Account account = new Account(username, email, password);
        Account savedAccount = accountRepository.save(account);

        return new AccountResponse(savedAccount.getUsername(), savedAccount.getEmail());
    }
}
