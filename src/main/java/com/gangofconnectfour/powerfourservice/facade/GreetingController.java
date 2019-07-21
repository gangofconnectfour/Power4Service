package com.gangofconnectfour.powerfourservice.facade;

/**
 * @author
 * @since
 **/

import com.gangofconnectfour.powerfourservice.api.in.AiDtoIn;
import com.gangofconnectfour.powerfourservice.api.out.AiDtoOut;
import com.gangofconnectfour.powerfourservice.api.out.HitOut;
import com.gangofconnectfour.powerfourservice.facade.exception.CallAiException;
import com.gangofconnectfour.powerfourservice.utils.Closures;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Controller
public class GreetingController {


    @PostMapping("/hello")
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ResponseEntity greeting(@RequestBody AiDtoOut out) {
        RestTemplate restTemplate = new RestTemplate();

        AiDtoIn in = restTemplate.postForObject("https://api-model-java.herokuapp.com/predict" , out, AiDtoIn.class);
        int value = maxFromArray(Closures.opt(in::getOutput).orElseThrow(CallAiException::new));
        return ResponseEntity.ok(new HitOut(value));
    }

    private int maxFromArray(float[] array) {
        if(array == null || array.length == 0) { return -1; }

        int max = 0;
        for(int i = 0; i < array.length; ++i) {
            if(array[i] > array[max]) { max = i; }
        }

        return max;
    }
}
