package team.world.trade.user.application.exception;

public class FailedToChangePassword extends RuntimeException {

    public FailedToChangePassword() {
        super("Failed to update the password.");
    }
}
