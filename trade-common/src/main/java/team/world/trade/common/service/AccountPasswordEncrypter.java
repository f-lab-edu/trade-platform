package team.world.trade.common.service;

import org.springframework.stereotype.Component;

@Component
public class AccountPasswordEncrypter implements PasswordEncrypter {

    private final PasswordEncrypter passwordEncrypter;

    public AccountPasswordEncrypter(PasswordEncrypter passwordEncrypter) {
        this.passwordEncrypter = passwordEncrypter;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncrypter.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncrypter.matches(rawPassword, encodedPassword);
    }
}
