package guru.springframework.spring6restmvc.services.ecommerce;

import guru.springframework.spring6restmvc.entities.ecommerce.Order;
import guru.springframework.spring6restmvc.repositories.ecommerce.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService{


    final OrderRepository orderRepository;

    OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    @Override
    public List<Order> findOrdersByCustomerId(Long customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    @Override
    public List<Order> findOrdersWithAmountGreaterThan(double orderAmount) {
        return orderRepository.findOrdersWithAmountGreaterThan(orderAmount);
    }
}
