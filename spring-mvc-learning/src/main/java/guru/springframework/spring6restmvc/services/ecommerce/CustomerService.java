package guru.springframework.spring6restmvc.services.ecommerce;

import guru.springframework.spring6restmvc.entities.ecommerce.Customer;
import guru.springframework.spring6restmvc.model.ecommerce.CustomerTotalSpendDTO;
import guru.springframework.spring6restmvc.utility.PaginatedResponse;

import java.util.List;

public interface CustomerService {

    PaginatedResponse<Customer> getAllCustomers(int page,int size);
    List<Customer> findAllCustomerWithPriceBetween(double start, double end);
    List<CustomerTotalSpendDTO> findTotalSpendPerCustomer();
}
