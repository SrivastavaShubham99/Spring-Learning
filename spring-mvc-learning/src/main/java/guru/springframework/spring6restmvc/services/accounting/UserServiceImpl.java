package guru.springframework.spring6restmvc.services.accounting;

import guru.springframework.spring6restmvc.entities.accounting.User;
import guru.springframework.spring6restmvc.model.UserLoginRequest;
import guru.springframework.spring6restmvc.repositories.accounting.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private PasswordEncoder passwordEncoder;


    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;




    UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager){
        this.userRepository=userRepository;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void saveUser(User user) {
        String password=passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User authenticate(UserLoginRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
