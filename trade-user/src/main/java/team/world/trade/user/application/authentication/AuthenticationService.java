package team.world.trade.user.application.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationService {

    String createAuth(String username, HttpServletResponse response);

    String getAuth(HttpServletRequest request);
}
