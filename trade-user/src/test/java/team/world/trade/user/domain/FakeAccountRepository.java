package team.world.trade.user.domain;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class FakeAccountRepository implements AccountRepository {

    private final Map<Long, Account> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public void save(Account account) {
        store.put(idGenerator.incrementAndGet(), account);
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        Account account = store.get(accountId);
        return Optional.of(account);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return store.values()
                .stream().filter(acc -> acc.getUsername().equals(username)).findFirst();
    }

    @Override
    public boolean existsByUsername(String username) {
        return store.values()
                .stream().anyMatch(acc -> acc.getUsername().equals(username));
    }

    @Override
    public boolean existsByEmail(String email) {
        return store.values()
                .stream().anyMatch(acc -> acc.getEmail().equals(email));
    }
}
