package team.world.trade.user.infrastructure;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import team.world.trade.user.infrastructure.authentication.AuthenticationService;
import team.world.trade.user.infrastructure.authentication.SessionManagerService;

public class AuthenticationAdapter implements AuthenticationService {

    private final SessionManagerService sessionManagerService;

    public AuthenticationAdapter(SessionManagerService sessionManagerService) {
        this.sessionManagerService = sessionManagerService;
    }

    @Override
    public String createAuth(String username, HttpServletResponse response) {
        return sessionManagerService.createAuth(username, response);
    }

    @Override
    public String getAuth(HttpServletRequest request) {
        return sessionManagerService.getAuth(request);
    }
}
