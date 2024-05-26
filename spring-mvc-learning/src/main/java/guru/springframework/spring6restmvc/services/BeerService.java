package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    // post the beer data into the db
    Beer saveBeer(Beer beer);

    //update the beer by id
    Beer updateBeerById(UUID id,Beer updatedBeer);

    // delete beer by id
    Beer deleteBeerById(UUID id);
}
