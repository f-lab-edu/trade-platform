package team.world.trade.user.application.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResponse {
    private Long userId;



    public PasswordResponse(Long userId) {
        this.userId = userId;
    }
}
