package team.world.trade.user.domain;


import java.util.Optional;

public interface AccountRepository {

    void save(Account account);

    Optional<Account> findById(Long accountId);

    Optional<Account> findByUsername(String username);

    boolean existByUsername(String username);

    boolean existByEmail(String email);

}
