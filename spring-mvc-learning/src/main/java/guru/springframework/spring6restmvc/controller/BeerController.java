package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.services.BeerServiceJPA;
import guru.springframework.spring6restmvc.utility.PaginatedResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;


@Slf4j
@RestController
public class BeerController {


    private final BeerServiceJPA beerServiceJPA;

    public BeerController( BeerServiceJPA beerServiceJPA) {
        this.beerServiceJPA = beerServiceJPA;
    }


    @RequestMapping("/api/v1/beer")
    public PaginatedResponse<BeerDTO> listBeers(
            @RequestParam(required = false) Optional<String> beerStyle,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ){
        return beerServiceJPA.listBeers(beerStyle,page,size);
    }
//
//    @RequestMapping(value = "api/v1/beer/{beerId}")
//    public BeerDTO getBeerById(@PathVariable("beerId") UUID id){
//
//        log.debug("Get Beer by Id - in controller");
//
//        return beerService.getBeerById(id);
//    }


    @PostMapping("/api/v1/beer")
    public ResponseEntity saveBeer(@RequestBody BeerDTO beer){
        BeerDTO savecBeer = beerServiceJPA.saveBeer(beer);

        // adding the headers and sending back in the response.
        HttpHeaders headers=new HttpHeaders();
        headers.add("location","api/v1/beer/" + savecBeer.getId().toString());

        // in order send the beer to the response headers
        // we just have to pass the Http headers to the ResponseEntity object
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }


    @GetMapping("/api/v1/beer/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId")UUID id){
        Optional<BeerDTO> beerByIdRes=beerServiceJPA.getBeerById(id);
        return beerByIdRes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());

    }



    /*
    This way of handling exception is specific to this method
    and its take certain Exception and returns back any specific
    status or custom messages accordingly.

    In order to handle the Exception globally we can have the
    @ControllerAdvice which is globally taken for all the controllers


     */


//    @ExceptionHandler(HttpClientErrorException.NotFound.class)
//    public ResponseEntity handleNotFoundException(){
//        return ResponseEntity.notFound().build();
//    }



//
//    @PutMapping("api/v1/updatebeer/{beerId}")
//    public ResponseEntity updateBeerByID(@PathVariable("beerId") UUID beerID,@RequestBody BeerDTO beer){
//        beerService.updateBeerById(beerID,beer);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//
//    }
//
//    @DeleteMapping("api/v1/beer/{beerId}")
//    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID beerId){
//        log.debug("Get Beer by Id - " + beerId);
//        beerService.deleteBeerById(beerId);
//        return new ResponseEntity(HttpStatus.OK);
//
//    }

}
