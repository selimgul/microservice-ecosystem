package gul.selim.microserviceEcosystem.order.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SMSResultListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-notify-response-q",durable = "true", autoDelete = "false"),
                    exchange = @Exchange(name = "sms-notify-response-ex", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
                    key = "sms-notify-response"))
    public void handleNotifyMessage(final String responseParam) {

        System.out.println("Order Microservice:Message received: " + responseParam);
    }

}
