package guru.springframework.spring6restmvc.repositories.ecommerce;

import guru.springframework.spring6restmvc.entities.ecommerce.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("")
    List<Order> findOrdersByCustomerId(@Param("customer_id") Long customerId);
}
