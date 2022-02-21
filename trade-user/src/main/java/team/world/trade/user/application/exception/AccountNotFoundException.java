package team.world.trade.user.application.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
        super("Account have not been founded.");
    }
}
