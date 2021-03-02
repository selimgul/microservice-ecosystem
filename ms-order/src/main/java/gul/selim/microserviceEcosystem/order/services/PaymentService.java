package gul.selim.microserviceEcosystem.order.services;

import gul.selim.microserviceEcosystem.order.models.NotifyRequest;
import gul.selim.microserviceEcosystem.order.models.Order;
import gul.selim.microserviceEcosystem.order.models.PaymentRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {
    @Autowired
    private RestTemplate rt;

    @Autowired
    private RabbitTemplate rabbit;

    public String placeOrder(final Order order) {
        PaymentRequest requestLoc = new PaymentRequest();
        requestLoc.setAmount(100);
        requestLoc.setCustomerId(order.getCustomerId());
        requestLoc.setCustomerName(order.getCustomerName());

        System.out.println("Order Microservice: Calling Accounting Microservice...");
        String retValLoc = this.rt.postForObject("http://ACCOUNTING/api/v1/payment/pay",
                requestLoc,
                String.class);

        System.out.println("Order Microservice: Accounting Microservice called. Response: " + retValLoc);

        NotifyRequest notifyRequestLoc = new NotifyRequest();
        notifyRequestLoc.setDest("1234567");
        notifyRequestLoc.setMessage("Siparişiniz alındı. Sayın: " + order.getCustomerName());

        System.out.println("Order Microservice: Sending sms-notify...");
        this.rabbit.convertAndSend("sms-notify-ex",
                "sms-notify",
                notifyRequestLoc);

        System.out.println("Order Microservice: sms-notify sent.");

        return retValLoc;

    }
}
