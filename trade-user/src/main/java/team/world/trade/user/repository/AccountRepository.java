package team.world.trade.user.repository;


import java.util.Optional;
import team.world.trade.user.model.Account;

public interface AccountRepository {

    Account save(Account account);

    Optional<Account> findById(Long accountId);

    Optional<Account> findByUsername(String username);

    boolean existByUsername(String username);

    boolean existByEmail(String email);

}
