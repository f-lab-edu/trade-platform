package team.world.trade.user.utils;

public class UserUtils {

    public static boolean isSameString(String password, String confirmedPassword) {
        return password.equals(confirmedPassword) ? true : false;
    }
}
