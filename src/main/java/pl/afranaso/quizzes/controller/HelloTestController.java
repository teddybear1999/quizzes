package pl.afranaso.quizzes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTestController {

    @GetMapping("/test")
    public String testController() {
        return "Spring-boot-starter-web works ;)";
    }
}
