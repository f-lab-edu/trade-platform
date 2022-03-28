package team.world.trade.user.infrastructure;

import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import team.world.trade.user.domain.Account;
import team.world.trade.user.domain.AccountRepository;
import team.world.trade.user.infrastructure.mybatis.AccountMapper;

@Primary
@Component
public final class AccountRepositoryAdapter implements AccountRepository {

    private AccountMapper accountMapper;

    public AccountRepositoryAdapter(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public void save(Account account) {
        accountMapper.insert(account);
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        return accountMapper.findById(accountId);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountMapper.findByUsername(username);
    }

    @Override
    public boolean existByUsername(String username) {
        return accountMapper.existByUsername(username);
    }

    @Override
    public boolean existByEmail(String email) {
        return accountMapper.existByEmail(email);
    }

    @Override
    public int update(Account account) {
        return accountMapper.update(account);
    }

}
