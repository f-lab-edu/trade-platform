package team.world.trade.user.application.authentication;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import team.world.trade.user.application.exception.SessionAuthenticationException;

public class SessionManagerService implements AuthenticationService {

    private final SessionManager sessionManager;

    public SessionManagerService(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public String createAuth(String username, HttpServletResponse response) {
        return sessionManager.createSession(username, response);
    }

    @Override
    public String getAuth(HttpServletRequest request) {
        return sessionManager.getSession(request);
    }

    public Cookie getCookie(HttpServletRequest request) {
        Cookie cookie = sessionManager.getCookie(request);
        if (cookie == null) {
            throw new RuntimeException("No sessionId exist");
        }
        return cookie;
    }

    public boolean alreadyLogin(HttpServletRequest request) {
        if (getCookie(request) == null) {
            return false;
        }
        throw new SessionAuthenticationException("The use is already logged-in.");
    }

    public String expireSession(HttpServletRequest request) {
        if (getCookie(request) == null) {
            throw new SessionAuthenticationException("The user is not logged in");
        }
        return sessionManager.expire(request);
    }
}
