package guru.springframework.spring6restmvc.services.ecommerce;

import guru.springframework.spring6restmvc.model.ecommerce.TopSellingProduct;
import guru.springframework.spring6restmvc.model.ecommerce.TopSellingProductDTO;
import guru.springframework.spring6restmvc.repositories.ecommerce.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public List<TopSellingProductDTO> getTopSellingProduct(int limit) {

        List<TopSellingProduct> products= productRepository.findTopSellingProducts(limit);
        return products.stream()
                .map( e ->
                        TopSellingProductDTO
                                .builder()
                                .productName(e.getProductName())
                                .productCount(e.getProductCount())
                                .productId(e.getProductId())
                                .build()).toList();
    }
}
