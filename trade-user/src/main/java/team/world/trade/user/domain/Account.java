package team.world.trade.user.domain;

import lombok.Getter;
import lombok.Setter;
import team.world.trade.user.application.exception.PasswordMismatchException;

@Getter
@Setter
public class Account {

    private Long id;

    private String username;

    private String email;

    private String password;

    public Account() {
    }

    public Account(Long id, String password) {
        this.id = id;
        this.password = password;
    }


    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void changePassword(String changePassword) {
        this.password = changePassword;
    }

}
