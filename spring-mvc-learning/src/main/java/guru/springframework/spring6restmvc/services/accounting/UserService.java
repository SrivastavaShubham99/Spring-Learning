package guru.springframework.spring6restmvc.services.accounting;

import guru.springframework.spring6restmvc.entities.accounting.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);

    public List<User> getAllUsers();
}
