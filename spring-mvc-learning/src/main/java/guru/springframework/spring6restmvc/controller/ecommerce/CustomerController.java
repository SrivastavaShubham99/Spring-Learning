package guru.springframework.spring6restmvc.controller.ecommerce;


import guru.springframework.spring6restmvc.entities.ecommerce.Customer;
import guru.springframework.spring6restmvc.model.ecommerce.CustomerTotalSpend;
import guru.springframework.spring6restmvc.model.ecommerce.CustomerTotalSpendDTO;
import guru.springframework.spring6restmvc.services.ecommerce.CustomerServiceImpl;
import guru.springframework.spring6restmvc.utility.PaginatedResponse;
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
@RequestMapping(ApiEndPoints.customer)
public class CustomerController {


    @Autowired
    private  CustomerServiceImpl customerService;

    @GetMapping
    public ResponseEntity<PaginatedResponse<Customer>> getAllCustomers(
            @RequestParam int page,
            @RequestParam int size
    ){
        PaginatedResponse<Customer> response=customerService.getAllCustomers(page,size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/between")
    public ResponseEntity<List<Customer>> getCustomerBetween(
            @RequestParam double start,
            @RequestParam double end
    ){
        List<Customer> response=customerService.findAllCustomerWithPriceBetween(start,end);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/totalSpendPerCustomer")
    public ResponseEntity<List<CustomerTotalSpendDTO>> findTotalSpendPerCustomer(){
        List<CustomerTotalSpendDTO> response=customerService.findTotalSpendPerCustomer();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
