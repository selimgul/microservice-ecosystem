package gul.selim.microserviceEcosystem.order.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NotifyRequest {

    private String message;
    private String dest;

}