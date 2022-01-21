package team.comito.trade.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

    @RequestMapping(path = "/main/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
