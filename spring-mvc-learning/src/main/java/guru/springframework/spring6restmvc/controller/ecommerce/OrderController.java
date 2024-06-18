package guru.springframework.spring6restmvc.controller.ecommerce;


import guru.springframework.spring6restmvc.entities.ecommerce.Order;
import guru.springframework.spring6restmvc.services.ecommerce.OrderServiceImpl;
import guru.springframework.spring6restmvc.utility.constants.ApiEndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiEndPoints.order)
public class OrderController {


    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findOrdersByCustomerId(@RequestParam Long customerId){
        List<Order> orders=orderService.findOrdersByCustomerId(customerId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @GetMapping("/greater-fetch")
    public ResponseEntity<List<Order>> findOrdersWithAmountGreaterThan(@RequestParam double amount){
        List<Order> orders=orderService.findOrdersWithAmountGreaterThan(amount);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
}
