package guru.springframework.spring6restmvc.services.ecommerce;

import guru.springframework.spring6restmvc.entities.ecommerce.Customer;
import guru.springframework.spring6restmvc.model.ecommerce.CustomerTotalSpend;
import guru.springframework.spring6restmvc.model.ecommerce.CustomerTotalSpendDTO;
import guru.springframework.spring6restmvc.repositories.ecommerce.CustomerRepository;
import guru.springframework.spring6restmvc.utility.PaginatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService{

    final CustomerRepository customerRepository;
    CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public PaginatedResponse<Customer> getAllCustomers(int page, int size) {
        Pageable pageable=PageRequest.of(page,size);
        Page<Customer> paginatedCustomerList=customerRepository.findAll(pageable);

        return new PaginatedResponse<>(paginatedCustomerList.getContent(),
                paginatedCustomerList.getNumber(),
                paginatedCustomerList.getSize(),
                paginatedCustomerList.getTotalElements(),
                paginatedCustomerList.getTotalPages(),
                paginatedCustomerList.isLast());
    }

    @Override
    public List<Customer> findAllCustomerWithPriceBetween(double start, double end) {
        return customerRepository.findCustomersWithOrdersTotalPriceBetween(start,end);
    }

    @Override
    public List<CustomerTotalSpendDTO> findTotalSpendPerCustomer() {
        List<CustomerTotalSpend> customerTotalSpend= customerRepository.findTotalSpendPerCustomer();
        return customerTotalSpend.stream().map( e -> new CustomerTotalSpendDTO(
                e.getCustomerName(),
                e.getTotalAmount(),
                e.getCustomerId()
        )).toList();
    }
}
