package team.world.trade.user.domain;

import team.world.trade.common.service.PasswordEncrypter;

public class FakePasswordEncrypter implements PasswordEncrypter {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
