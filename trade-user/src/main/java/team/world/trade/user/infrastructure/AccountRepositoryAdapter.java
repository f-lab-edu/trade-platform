package team.world.trade.user.infrastructure;

import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import team.world.trade.user.domain.Account;
import team.world.trade.user.domain.AccountRepository;
import team.world.trade.user.infrastructure.jpa.JpaAccountRepository;

@Primary
@Component
public final class AccountRepositoryAdapter implements AccountRepository {

    private JpaAccountRepository jpaAccountRepository;

    public AccountRepositoryAdapter(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public void save(Account account) {
        jpaAccountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        return jpaAccountRepository.findById(accountId);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return jpaAccountRepository.findByUsername(username);
    }

    @Override
    public boolean existByUsername(String username) {
        return jpaAccountRepository.existByUsername(username);
    }

    @Override
    public boolean existByEmail(String email) {
        return jpaAccountRepository.existByEmail(email);
    }

}
