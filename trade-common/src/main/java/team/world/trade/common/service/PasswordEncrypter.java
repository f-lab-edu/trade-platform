package team.world.trade.common.service;

public interface PasswordEncrypter {

    String encode(CharSequence rawPassword);

    boolean matches(CharSequence rawPassword, String encodedPassword);
}
