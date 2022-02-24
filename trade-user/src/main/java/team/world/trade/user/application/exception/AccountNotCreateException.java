package team.world.trade.user.application.exception;

public class AccountNotCreateException extends RuntimeException {

    public AccountNotCreateException() {
        super("Account not created due to password mismatch");
    }
}
