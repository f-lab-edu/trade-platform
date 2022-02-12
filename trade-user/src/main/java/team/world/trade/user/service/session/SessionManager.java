package team.world.trade.user.service.session;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import team.world.trade.user.model.Account;
import team.world.trade.user.response.payload.AccountResponse;

@Component
public class SessionManager {

    public static final String SESSION_COOKIE_NAME = "mySessionId";
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    public void createSession(Object value, HttpServletResponse response) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);
        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(cookie);
    }

    public AccountResponse getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request);
        if (sessionCookie == null) {
            return null;
        }
        Account account = (Account) sessionStore.get(sessionCookie.getValue());
        return new AccountResponse(account.getUsername(), account.getEmail());
    }

    public AccountResponse expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request);
        if (sessionCookie != null) {
            Account account = (Account) sessionStore.get(sessionCookie.getValue());
            sessionStore.remove(sessionCookie.getValue());
            return new AccountResponse(account.getUsername(), account.getEmail());
        }
        return null;
    }

    private Cookie findCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }

        return Arrays.stream(cookies)
                .filter(c -> c.getName().equals(SESSION_COOKIE_NAME))
                .findAny()
                .orElse(null);
    }
}
