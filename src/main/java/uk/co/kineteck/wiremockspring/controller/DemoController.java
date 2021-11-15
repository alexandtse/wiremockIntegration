package uk.co.kineteck.wiremockspring.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    private WireMockServer wireMockServer;

    @Autowired
    public DemoController(WireMockServer wireMockServer) {
        this.wireMockServer = wireMockServer;
    }

    @GetMapping("/greeting")
    public String getGreetingMessage() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8091";
        ResponseEntity<String> response
                = restTemplate.getForEntity(url + "/apiCall", String.class);
        return "From Greeting " + response.getBody();
    }
    @GetMapping("/reload")
    public String restartWireMock() {
        RestTemplate restTemplate = new RestTemplate();
        WireMock.configureFor(8091);
        WireMock.reset();
        return "Request accepted";
    }
}
