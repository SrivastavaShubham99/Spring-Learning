package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.mapper.BeerMapper;
import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.model.BeerStyle;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import guru.springframework.spring6restmvc.utility.PaginatedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class BeerServiceJPA implements BeerService{

    private BeerRepository beerRepository;

    public BeerServiceJPA(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Autowired
    BeerMapper beerMapper;


    @Override
    public PaginatedResponse<BeerDTO> listBeers(Optional<String> beerStyle, Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Beer> beerPage=beerRepository.findAll(pageable);
        if(beerStyle.isPresent()){
            BeerStyle style = BeerStyle.valueOf(beerStyle.get().toUpperCase());
            List<BeerDTO> beerDTOS=beerPage.stream()
                    .filter( ele -> ele.getBeerStyle().equals(style))
                    .map(beerMapper::beerToBeerDto).toList();
            return new PaginatedResponse<>(beerDTOS,beerPage.getNumber(), beerPage.getSize(),
                    beerPage.getTotalElements(), beerPage.getTotalPages(),
                    beerPage.isLast());
        }else{
            return new PaginatedResponse<>(beerPage.getContent().stream().map(beerMapper::beerToBeerDto).toList(), beerPage.getNumber(), beerPage.getSize(),
                    beerPage.getTotalElements(), beerPage.getTotalPages(),
                    beerPage.isLast());
        }

    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        Optional<Beer> beer=beerRepository.findById(id);
        return beer.map( e -> beerMapper.beerToBeerDto(e));
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beerDto) {
        Beer beer=beerRepository.save(beerMapper.beerDtoToBeer(beerDto));
        return beerMapper.beerToBeerDto(beer);
    }

    @Override
    public BeerDTO updateBeerById(UUID id, BeerDTO updatedBeer) {
        return null;
    }

    @Override
    public BeerDTO deleteBeerById(UUID id) {
        return null;
    }


}
