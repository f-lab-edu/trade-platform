package team.world.trade.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    private Long id;

    private String username;

    private String email;

    private String password;

    public Account(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}