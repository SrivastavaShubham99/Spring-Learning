package guru.springframework.spring6restmvc.controller.accounting;


import guru.springframework.spring6restmvc.entities.accounting.User;
import guru.springframework.spring6restmvc.model.MessageResponse;
import guru.springframework.spring6restmvc.services.accounting.UserServiceImpl;
import guru.springframework.spring6restmvc.utility.constants.ApiEndPoints;
import guru.springframework.spring6restmvc.utility.constants.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiEndPoints.userEndPoint)
public class UserController {


    @Autowired
    private UserServiceImpl userService;


    @PostMapping
    public ResponseEntity<MessageResponse> saveUser(@RequestBody User user){
        userService.saveUser(user);
        MessageResponse messageResponse=MessageResponse.builder()
                .message(Messages.userAdded)
                .build();
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }
}
