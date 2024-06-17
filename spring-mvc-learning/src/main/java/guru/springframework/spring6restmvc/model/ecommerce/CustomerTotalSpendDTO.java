package guru.springframework.spring6restmvc.model.ecommerce;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTotalSpendDTO {

    private String customerName;

    private double totalSpend;

    private Long customerId;
}
