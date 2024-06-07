package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;




public interface BeerRepository extends JpaRepository<Beer, UUID> {


    Beer save(Beer beer);
    Page<Beer> findAll(Pageable pageable);

    Optional<Beer> findById(UUID id);
}
