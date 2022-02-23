package team.world.trade.user.infrastructure.mybatis;

import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import team.world.trade.user.domain.Account;
import team.world.trade.user.domain.AccountRepository;

@Mapper
public interface AccountMapper extends AccountRepository {

    void insert(Account account);

    Optional<Account> findById(Long accountId);

    Optional<Account> findByUsername(String username);

    boolean existByUsername(String username);

    boolean existByEmail(String email);
}
