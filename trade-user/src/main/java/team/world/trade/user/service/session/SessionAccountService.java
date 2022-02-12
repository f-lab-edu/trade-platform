package team.world.trade.user.service.session;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import team.world.trade.user.response.payload.AccountResponse;

@Service
public class SessionAccountService {

    private final SessionManager sessionManager;

    public SessionAccountService(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public AccountResponse logout(HttpServletRequest request) {
        return sessionManager.expire(request);
    }

    public AccountResponse home(HttpServletRequest request) {
        return sessionManager.getSession(request);
    }
}
