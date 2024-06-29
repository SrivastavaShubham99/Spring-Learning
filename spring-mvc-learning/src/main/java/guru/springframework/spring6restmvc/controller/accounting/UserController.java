package guru.springframework.spring6restmvc.controller.accounting;


import guru.springframework.spring6restmvc.entities.accounting.User;
import guru.springframework.spring6restmvc.model.MessageResponse;
import guru.springframework.spring6restmvc.model.UserLoginRequest;
import guru.springframework.spring6restmvc.model.UserLoginResponse;
import guru.springframework.spring6restmvc.security.JWTServiceUtil;
import guru.springframework.spring6restmvc.services.accounting.UserServiceImpl;
import guru.springframework.spring6restmvc.utility.constants.ApiEndPoints;
import guru.springframework.spring6restmvc.utility.constants.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiEndPoints.userEndPoint)
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JWTServiceUtil jwtServiceUtil;




    @PostMapping
    public ResponseEntity<MessageResponse> saveUser(@RequestBody User user){
        userService.saveUser(user);
        MessageResponse messageResponse=MessageResponse.builder()
                .message(Messages.userAdded)
                .build();
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginRequest userLoginRequest){
        User userRes=userService.authenticate(userLoginRequest);
        String token = jwtServiceUtil.generateToken(userRes,userRes.getId());
        UserLoginResponse userLoginResponse=new UserLoginResponse();
        userLoginResponse.setToken(token);
        return new ResponseEntity<>(userLoginResponse,HttpStatus.OK);

    }
}
