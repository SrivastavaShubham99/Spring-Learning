package guru.springframework.spring6restmvc.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by jt, Spring Framework Guru.
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

    }

    @Override
    public List<Beer> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return beerMap.get(id);
    }

    @Override
    public Beer saveBeer(Beer beer) {
        Beer savedBeer= Beer.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .version(beer.getVersion())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .build();

        // put this new beer into the map
        beerMap.put(savedBeer.getId(),savedBeer);

        return savedBeer;
    }

    @Override
    public Beer updateBeerById(UUID id,Beer updatedBeer) {
        Beer updateBeer=beerMap.get(id);
        updateBeer.setBeerName(updatedBeer.getBeerName());
        updateBeer.setBeerStyle(updatedBeer.getBeerStyle());
        updateBeer.setPrice(updatedBeer.getPrice());
        updateBeer.setVersion(updatedBeer.getVersion());

        return updateBeer;

    }

    @Override
    public Beer deleteBeerById(UUID id) {
        Beer beerToBeDeleted=beerMap.get(id);
        beerMap.remove(id,beerToBeDeleted);
        return beerToBeDeleted;
    }




}
