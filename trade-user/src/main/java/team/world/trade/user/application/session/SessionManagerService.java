package team.world.trade.user.application.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import team.world.trade.user.application.exception.SessionAuthenticationException;

@Service
public class SessionManagerService {

    private SessionManager sessionManager;

    public SessionManagerService(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void createSession(Object value, HttpServletResponse response) {
        sessionManager.createSession(value, response);
    }

    public String expireSession(HttpServletRequest request) {
        if (getAttribute(request) == null) {
            throw new SessionAuthenticationException("The user is not logged in");
        }
        return sessionManager.expire(request);
    }

    public String getAttribute(HttpServletRequest request) {
        return (String) sessionManager.getSession(request);
    }

    public boolean alreadyLogin(HttpServletRequest request) {
        if (getAttribute(request) == null) {
            return false;
        }
        throw new SessionAuthenticationException("The use is already logged-in.");
    }

}
