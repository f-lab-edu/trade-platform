package team.world.trade.user.application.exception;

public class PasswordMismatchException extends RuntimeException {

    public PasswordMismatchException() {
        super("The password is not matched.");
    }
}
