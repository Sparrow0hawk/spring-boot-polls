package com.coleman.polls;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePage {
    @Value("${spring.application.name")
    String appName;

    @GetMapping(value = "/", produces = "text/html")
    public @ResponseBody String homePage() {
        return "<h1>Hello world!</h1>";
    }
}
