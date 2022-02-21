package team.world.trade.user.infrastructure;


import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import team.world.trade.user.domain.Account;

@Mapper
public interface AccountRepository {

    Account save(Account account);

    Optional<Account> findById(Long accountId);

    Optional<Account> findByUsername(String username);

    boolean existByUsername(String username);

    boolean existByEmail(String email);

}
