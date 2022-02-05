package team.world.trade.user.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
        super("Account have not been founded.");
    }
}
