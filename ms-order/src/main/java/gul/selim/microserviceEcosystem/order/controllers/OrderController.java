package gul.selim.microserviceEcosystem.order.controllers;

import gul.selim.microserviceEcosystem.order.models.Order;
import gul.selim.microserviceEcosystem.order.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Value("${config-key:}")
    private String configKey;

    @Value("${server.port}")
    private int port;

    @Autowired
    private PaymentService ps;

    @GetMapping("/pconfig")
    public String logConfig() {
        System.out.println(configKey);
        return "Config values logged to console.";
    }

    @PostMapping("/place")
    public String place(@RequestBody final Order order) {
        return this.ps.placeOrder(order);
    }
}
