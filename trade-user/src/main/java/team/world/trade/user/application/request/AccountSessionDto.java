package team.world.trade.user.application.request;


import java.io.Serializable;

public class AccountSessionDto implements Serializable {

    private String username;


    public AccountSessionDto() {
    }

    public AccountSessionDto(String username, String email) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
