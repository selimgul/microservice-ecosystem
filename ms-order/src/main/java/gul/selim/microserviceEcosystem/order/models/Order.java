package gul.selim.microserviceEcosystem.order.models;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String       orderName;
    private String       customerName;
    private String       customerId;
    private List<String> meals;
}
