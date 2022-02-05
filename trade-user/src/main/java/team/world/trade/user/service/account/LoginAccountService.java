package team.world.trade.user.service.account;

import org.springframework.stereotype.Service;
import team.world.trade.user.exception.AccountNotFoundException;
import team.world.trade.user.model.Account;
import team.world.trade.user.repository.AccountRepository;
import team.world.trade.user.response.payload.AccountResponse;

@Service
public final class LoginAccountService {

    private final AccountRepository accountRepository;

    public LoginAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse login(String username, String password) {
        Account account = accountRepository.findByUsername(username).orElseThrow();

        if (!account.validatePassword(password)) {
            throw new AccountNotFoundException();
        }
        return new AccountResponse(account.getUsername(), account.getEmail());
    }

}
