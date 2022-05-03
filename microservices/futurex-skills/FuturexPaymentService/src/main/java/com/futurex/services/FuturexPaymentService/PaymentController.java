package com.futurex.services.FuturexPaymentService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PaymentController {

    @Value("${organization.name}")
    private String organizationName;

    @Value("${service.welcome.message}")
    private String welcomeMessage;

    @RequestMapping(method = RequestMethod.GET, value = "/sample")
    public String getWelcomeMessage() {
        return "Hello from Payment Service!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home() {
        return organizationName + " " + welcomeMessage;
    }
}
