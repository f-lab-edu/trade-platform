package team.world.trade.user.application.request;


import java.io.Serializable;

public class AccountSessionDto implements Serializable {

    private String username;

    private String email;

    public AccountSessionDto() {
    }

    public AccountSessionDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
