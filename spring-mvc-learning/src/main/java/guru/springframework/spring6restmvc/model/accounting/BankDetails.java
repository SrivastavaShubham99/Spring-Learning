package guru.springframework.spring6restmvc.model.accounting;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankDetails {

    private String accountNumber;

    private String message;

    private double amountLeft;
}
