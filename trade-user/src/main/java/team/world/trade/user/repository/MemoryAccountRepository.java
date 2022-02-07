package team.world.trade.user.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;
import team.world.trade.user.model.Account;

@Repository
public class MemoryAccountRepository implements AccountRepository {

    private static Map<Long, Account> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public Account save(Account account) {
        account.setId(sequence++);
        store.put(sequence, account);
        return account;
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        return Optional.ofNullable(store.get(accountId));
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return store.values().stream()
                .filter(account -> account.getUsername().equals(username))
                .findAny();
    }

    @Override
    public boolean existByUsername(String username) {
        return store.values().stream()
                .anyMatch(account -> account.getUsername().equals(username));
    }

    @Override
    public boolean existByEmail(String email) {
        return store.values().stream()
                .anyMatch(account -> account.getEmail().equals(email));
    }
}
