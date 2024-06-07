package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.utility.PaginatedResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BeerService {

    PaginatedResponse<BeerDTO> listBeers(Optional<String> beerStyle, Integer page, Integer size);

    Optional<BeerDTO> getBeerById(UUID id);

    // post the beer data into the db
    BeerDTO saveBeer(BeerDTO beer);

    //update the beer by id
    BeerDTO updateBeerById(UUID id, BeerDTO updatedBeer);

    // delete beer by id
    BeerDTO deleteBeerById(UUID id);

    // find beer by id
}
