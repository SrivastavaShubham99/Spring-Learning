package guru.springframework.spring6restmvc.services.ecommerce;

import guru.springframework.spring6restmvc.entities.ecommerce.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findOrdersByCustomerId(Long customerId);

    public List<Order> findOrdersWithAmountGreaterThan(double orderAmount);
}
