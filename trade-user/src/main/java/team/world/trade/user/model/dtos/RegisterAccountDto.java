package team.world.trade.user.model.dtos;


public class RegisterAccountDto {

    private String username;

    private String email;

    private String password;

    public RegisterAccountDto() {
    }

    public RegisterAccountDto(String username, String email, String password,
                              String confirmedPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
