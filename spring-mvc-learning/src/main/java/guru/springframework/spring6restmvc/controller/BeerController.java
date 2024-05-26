package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
    private final BeerService beerService;

    @RequestMapping("/api/v1/beer")
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    @RequestMapping(value = "api/v1/beer/{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID id){

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(id);
    }


    @PostMapping("/api/v1/savebeer")
    public ResponseEntity saveBeer(@RequestBody  Beer beer){
        Beer savecBeer = beerService.saveBeer(beer);

        // adding the headers and sending back in the response.
        HttpHeaders headers=new HttpHeaders();
        headers.add("location","api/v1/beer/" + savecBeer.getId().toString());

        // in order send the beer to the response headers
        // we just have to pass the Httpheaders to the ResponseEntity object
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }


    @PutMapping("api/v1/updatebeer/{beerId}")
    public ResponseEntity updateBeerByID(@PathVariable("beerId") UUID beerID,@RequestBody Beer beer){
        beerService.updateBeerById(beerID,beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("api/v1/beer/{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("Get Beer by Id - " + beerId);
        beerService.deleteBeerById(beerId);
        return new ResponseEntity(HttpStatus.OK);

    }

}
