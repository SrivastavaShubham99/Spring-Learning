package guru.springframework.spring6restmvc.model.ecommerce;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class TopSellingProductDTO {

    private int productCount;
    private Long productId;
    private String productName;
}
