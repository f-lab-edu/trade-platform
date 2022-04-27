package team.world.trade.user.domain;


public interface PasswordEncrypter {

    String encode(CharSequence rawPassword);

    boolean matches(CharSequence rawPassword, String encodedPassword);
}
