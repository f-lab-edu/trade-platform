package team.world.trade.user.infrastructure.jpa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import team.world.trade.user.domain.Account;

public interface JpaAccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

    boolean existsByUsername(String email);

    boolean existsByEmail(String username);

}
