package guru.springframework.spring6restmvc.services.ecommerce;

import guru.springframework.spring6restmvc.model.ecommerce.TopSellingProductDTO;

import java.util.List;

public interface ProductService {

    List<TopSellingProductDTO> getTopSellingProduct(int limit);
}
