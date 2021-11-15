package uk.co.kineteck.wiremockspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @GetMapping("/apiCall")
    public String apiResponse() {
        return "Hello Alex!";
    }
}
