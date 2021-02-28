package gul.selim.microserviceEcosystem.accounting.controllers;

import gul.selim.microserviceEcosystem.accounting.models.PaymentRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/pay")
    public String pay(@Validated @RequestBody final PaymentRequest pr) {
        System.out.println("Accounting Microservice: Request got: " + pr);

        System.out.println("Accounting Microservice: Current instance is running on port: " + this.port);

        return "Accounting Microservice (" + this.port + "): Payment success ";
    }
}
