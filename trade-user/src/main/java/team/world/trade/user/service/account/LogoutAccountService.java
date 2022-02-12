package team.world.trade.user.service.account;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import team.world.trade.user.response.payload.AccountResponse;
import team.world.trade.user.service.session.SessionManager;

@Service
public class LogoutAccountService {

    private final SessionManager sessionManager;

    public LogoutAccountService(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }


}
