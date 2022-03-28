package team.world.trade.user.application.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PasswordRequest {

    private String originalPassword;
    private String changePassword;
}
