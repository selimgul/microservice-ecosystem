package gul.selim.microserviceEcosystem.notification.listener;

import gul.selim.microserviceEcosystem.notification.models.NotifyRequest;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @Value("${server.port}")
    private Integer port;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-notify-q", durable = "true", autoDelete = "false"),
                    exchange = @Exchange(name = "sms-notify-ex", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
                    key = "sms-notify"))
    @SendTo("sms-notify-response-ex/sms-notify-response")
    public String handleNotifyMessage(final NotifyRequest notifyRequestParam) {

        System.out.println("Notification Microservice: Message received: " + notifyRequestParam);
        System.out.println("Notification Microservice: Current instance is running on port: " + this.port);
        System.out.println("Notification Microservice: Sending new message: Notification Microservice (" + this.port + "): Processed successfully.");

        return "Notification Microservice (" + this.port + "): Processed successfully: " + notifyRequestParam;
    }
}
