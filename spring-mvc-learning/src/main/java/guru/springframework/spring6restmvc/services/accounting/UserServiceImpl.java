package guru.springframework.spring6restmvc.services.accounting;

import guru.springframework.spring6restmvc.entities.accounting.User;
import guru.springframework.spring6restmvc.repositories.accounting.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;



    UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
