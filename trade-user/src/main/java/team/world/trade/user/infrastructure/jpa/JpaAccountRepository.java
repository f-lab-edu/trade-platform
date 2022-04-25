package team.world.trade.user.infrastructure.jpa;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import team.world.trade.user.domain.Account;
import team.world.trade.user.domain.AccountRepository;

@Repository
public class JpaAccountRepository implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Account account) {
        entityManager.persist(account);
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        Account account = entityManager.find(Account.class, accountId);
        return Optional.of(account);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        List<Account> account = entityManager.createQuery(
                        "select u from Account u where u.username = :username", Account.class
                ).setParameter("username", username)
                .getResultList();
        return account.stream().findAny();
    }

    @Override
    public boolean existByUsername(String username) {
        List<Account> account =
                entityManager.createQuery("select u from Account u where u.username = :username",
                                Account.class)
                        .setParameter("username", username)
                        .getResultList();
        return account.stream().findAny().isPresent();
    }

    @Override
    public boolean existByEmail(String email) {
        List<Account> account =
                entityManager.createQuery("select u from Account u where u.email = :email",
                                Account.class)
                        .setParameter("email", email)
                        .getResultList();
        return account.stream().findAny().isPresent();
    }
}
