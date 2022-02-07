package team.world.trade.user.service.encrypt.salt;

public interface SaltRepository {

    String save(String username, String salt);

    String findSaltByUsername(String username);

}
