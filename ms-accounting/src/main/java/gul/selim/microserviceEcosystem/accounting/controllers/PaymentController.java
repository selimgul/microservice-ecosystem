package gul.selim.microserviceEcosystem.accounting.controllers;

import gul.selim.microserviceEcosystem.accounting.models.PaymentRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@RefreshScope
public class PaymentController {

    @Value("${config-key:}")
    private String configKey;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/pconfig")
    public String logConfig() {
        System.out.println(configKey);
        return "Config values logged to console.";
    }

    @PostMapping("/pay")
    public String pay(@Validated @RequestBody final PaymentRequest pr) {
        System.out.println("Accounting Microservice: Request got: " + pr);

        System.out.println("Accounting Microservice: Current instance is running on port: " + this.port);

        return "Accounting Microservice (" + this.port + "): Payment success ";
    }
}
