package team.world.trade.user.application.payload;

import lombok.Getter;

@Getter
public class AccountResponse {

    private String username;

    private String email;

    public AccountResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }
}