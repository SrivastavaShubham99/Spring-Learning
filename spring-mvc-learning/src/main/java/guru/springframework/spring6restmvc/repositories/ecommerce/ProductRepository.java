package guru.springframework.spring6restmvc.repositories.ecommerce;

import guru.springframework.spring6restmvc.entities.ecommerce.Product;
import guru.springframework.spring6restmvc.model.ecommerce.TopSellingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select count(p.product_id) as productCount,p.product_id as productId,p2.`name` as productName " +
            "from order_item p inner join product p2 on p.product_id=p2.id " +
            "group by p.product_id order by productCount desc limit :limit",nativeQuery = true)
    List<TopSellingProduct> findTopSellingProducts(@Param("limit") int limit);
}
