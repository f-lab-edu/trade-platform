package team.world.trade.user.infrastructure.authentication;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {

    public static final String SESSION_COOKIE_NAME = "mySessionId";
    private Map<String, String> sessionStore = new ConcurrentHashMap<>();

    public String createSession(String value, HttpServletResponse response) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);
        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(cookie);
        return sessionId;
    }

    public Cookie getCookie(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request);
        if (sessionCookie == null) {
            return null;
        }
        return sessionCookie;
    }


    public String getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request);
        if (sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
    }


    public String expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request);
        if (sessionCookie != null) {
            sessionStore.remove(sessionCookie.getValue());
            return sessionCookie.getValue();
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
