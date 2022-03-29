package team.world.trade.user.infrastructure.mybatis;

import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import team.world.trade.user.domain.Account;

@Mapper
public interface AccountMapper {

    void insert(Account account);

    int update(Account account);

    Optional<Account> findById(Long accountId);

    Optional<Account> findByUsername(String username);

    boolean existByUsername(String username);

    boolean existByEmail(String email);


}
