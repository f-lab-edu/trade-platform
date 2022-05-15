package team.world.trade.user.application.response;

import lombok.Getter;

@Getter
public class AccountResponse {

    private String username;

    private String email;

    private String token;

    public AccountResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public AccountResponse(String username, String email, String token) {
        this.username = username;
        this.email = email;
        this.token = token;
    }
}