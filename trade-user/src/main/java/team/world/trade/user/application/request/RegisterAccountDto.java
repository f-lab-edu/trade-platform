package team.world.trade.user.application.request;


import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Schema(description = "로그인 요청")
public class RegisterAccountDto {

    private String username;

    @NotBlank
    @Email
    @Schema(description = "이메일", example = "kitty123@gmail.com", required = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z1-9~!@#$%^&*()+|=]{8,12}$",
            message = "Please enter the password in English, numbers, "
                    + "and special characters within 8-12 digits.")
    private String password;

    public RegisterAccountDto() {
    }

    public RegisterAccountDto(String username, String email, String password) {
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
