package gul.selim.microserviceEcosystem.accounting.models;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ToString
public class PaymentRequest {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String customerName;
    @NotEmpty
    @Size(min = 6, max = 8)
    private String customerId;
    @Max(1000)
    @Min(10)
    private long   amount;
}
