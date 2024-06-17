package guru.springframework.spring6restmvc.repositories.ecommerce;

import guru.springframework.spring6restmvc.entities.ecommerce.Customer;
import guru.springframework.spring6restmvc.model.ecommerce.CustomerTotalSpend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findAll(Pageable pageable);


    @Query("SELECT DISTINCT c FROM Customer c LEFT JOIN c.orders o " +
            "WHERE o.totalAmount BETWEEN :startTotalPrice AND :endTotalPrice")
    List<Customer> findCustomersWithOrdersTotalPriceBetween(
            @Param("startTotalPrice") double startTotalPrice,
            @Param("endTotalPrice") double endTotalPrice);


//    @Query("SELECT new guru.springframework.spring6restmvc.model.ecommerce.CustomerTotalSpend(c.name,SUM(o.totalAmount),c.id) FROM Customer c " +
//            "INNER JOIN c.orders o GROUP BY c.id ORDER BY SUM(o.totalAmount) ASC")
//    List<CustomerTotalSpend> findTotalSpendPerCustomer();

    @Query(value = "select c.`name` AS customerName,sum(o.total_amount) AS totalAmount,o.customer_id AS customerId from customer c " +
            "inner join `order` o on o.customer_id=c.id " +
            "group by o.customer_id order by sum(o.total_amount) asc;",nativeQuery = true)
    List<CustomerTotalSpend> findTotalSpendPerCustomer();
}
