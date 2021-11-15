package uk.co.kineteck.wiremockspring.applicationContextInitializer;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

public class WiremockApplicationContextInitializer  implements ApplicationContextInitializer<ConfigurableApplicationContext> {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        boolean wiremockEnable = System.getProperty("wireMock")!= null  && System.getProperty("wireMock").equalsIgnoreCase("true");
        if(wiremockEnable) {
            WireMockServer wireMockServer;
            String filePath = System.getProperty("location");
            if(null == filePath) {
                wireMockServer = new WireMockServer(new WireMockConfiguration().port(8091));
            } else {
                wireMockServer = new WireMockServer(new WireMockConfiguration().port(8091).usingFilesUnderDirectory(filePath));
            }

            wireMockServer.start();
            System.out.println("wiremock server started");

            applicationContext.getBeanFactory().registerSingleton("wireMockServer", wireMockServer);

            applicationContext.addApplicationListener(applicationEvent ->{
                if(applicationEvent instanceof ContextClosedEvent) {
                    wireMockServer.stop();
                }
            });
        }

    }
}
