package team.world.trade.chat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ChatControllerTest {

    @RequestMapping(path = "/chat/test")
    public ResponseEntity<?> controllerTest() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
