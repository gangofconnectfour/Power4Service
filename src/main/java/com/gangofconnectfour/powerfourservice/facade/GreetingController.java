package com.gangofconnectfour.powerfourservice.facade;

/**
 * @author
 * @since
 **/
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ResponseEntity greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return ResponseEntity.ok("Hello, " + HtmlUtils.htmlEscape(message) + "!");
    }

}