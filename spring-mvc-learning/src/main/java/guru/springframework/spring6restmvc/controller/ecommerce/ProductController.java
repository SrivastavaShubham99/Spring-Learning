package guru.springframework.spring6restmvc.controller.ecommerce;


import guru.springframework.spring6restmvc.model.ecommerce.TopSellingProductDTO;
import guru.springframework.spring6restmvc.services.ecommerce.ProductServiceImpl;
import guru.springframework.spring6restmvc.utility.constants.ApiEndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiEndPoints.product)
public class ProductController {


    @Autowired
    private ProductServiceImpl productService;


    @GetMapping
    public ResponseEntity<List<TopSellingProductDTO>> getTopSellingProduct(@RequestParam int limit){
        List<TopSellingProductDTO> products=productService.getTopSellingProduct(limit);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
