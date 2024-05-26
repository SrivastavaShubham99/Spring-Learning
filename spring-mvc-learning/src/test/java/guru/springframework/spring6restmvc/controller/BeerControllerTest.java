package guru.springframework.spring6restmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import guru.springframework.spring6restmvc.services.BeerServiceImpl;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Autowired
    ObjectMapper objectMapper;

    BeerServiceImpl beerServiceImpl;

    @BeforeEach
    void setUp() {
        beerServiceImpl=new BeerServiceImpl();
    }

    /*
        This annotation tells the Mockito to create mock for the service and
        mock all the dependencies in proper way.
         */
    @MockBean
    BeerService beerService;



    @Test
    void getBeerById() throws Exception {

        Beer testBeer=Beer.builder()
                .beerName("BroCode Ultra Strong")
                        .id(UUID.randomUUID())
                        .price(new BigDecimal(12.23))
                        .beerName("Crank")
                        .build();
        // this is telling mockito that we are expecting Beer instance object
        // if we are hitting the service class.
        given(beerService.getBeerById(any(UUID.class))).willReturn(testBeer);


        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id",is(testBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName",is(testBeer.getBeerName())));


    }


    @Test
    void postBeerTest() throws Exception{

        Beer beer=Beer.builder()
                        .beerName("Crank")
                                .id(UUID.randomUUID()).build();

        // Mock the behavior of the beerService's saveBeer method.
        // When saveBeer is called with any Beer object, it will return the created beer object.

        given(beerService.saveBeer(any(Beer.class))).willReturn(beer);

        // Perform a POST request to the "/api/v1/savebeer" endpoint.
        // Set the accepted response media type to application/json.
        // Set the request content type to application/json.
        // Convert the beer object to a JSON string and set it as the request body.

        mockMvc.perform(post("/api/v1/savebeer")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(beer)))

                // Expect the HTTP status code of the response to be 201 (Created).

                .andExpect(status().isCreated())

                // Expect the response header to contain a "Location" header.

                .andExpect(header().exists("Location"));
    }

    @Test
    public void testUpdateBeerByID() throws Exception {
        Beer beer = Beer.builder()
                // Create a new Beer object and set its properties
        .beerName("Updated Beer")
                .id(UUID.randomUUID())
        .price(BigDecimal.valueOf(9.99))
        .version(1).build();

        // Mock the behavior of the beerService.updateBeerById method
        when(beerService.updateBeerById(any(UUID.class), any(Beer.class))).thenReturn(beer);

        // Perform a PUT request to update the beer and check if the response status is NO_CONTENT
        mockMvc.perform(put("/api/v1/updatebeer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)  // Set the content type of the request to JSON
                        .content(asJsonString(beer)))  // Convert the Beer object to JSON and set it as the request body
                .andExpect(status().isNoContent());  // Expect the response status to be 204 NO_CONTENT

        // Verify that the beerService.updateBeerById method was called exactly once with the specified parameters
        verify(beerService, times(1)).updateBeerById(any(UUID.class), any(Beer.class));
    }

    @Test
    public void testDeleteBeerById() throws Exception {
        UUID beerId = UUID.randomUUID();  // Generate a random UUID for the beer ID

        // Mock the behavior of the beerService.deleteBeerById method

        // Perform a DELETE request to delete the beer and check if the response status is OK
        mockMvc.perform(delete("/api/v1/beer/" + beerId))
                .andExpect(status().isOk());  // Expect the response status to be 200 OK

        // Verify that the beerService.deleteBeerById method was called exactly once with the specified parameter
        verify(beerService, times(1)).deleteBeerById(beerId);
    }

    // Helper method to convert an object to a JSON string using Jackson's ObjectMapper
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);  // Convert the object to a JSON string
        } catch (Exception e) {
            throw new RuntimeException(e);  // Throw a runtime exception if conversion fails
        }
    }
}