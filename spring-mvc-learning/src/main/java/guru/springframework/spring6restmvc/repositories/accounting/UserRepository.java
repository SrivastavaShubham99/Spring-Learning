package guru.springframework.spring6restmvc.repositories.accounting;

import guru.springframework.spring6restmvc.entities.accounting.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Boolean existsByFirstNameAndLastName(String firstName,String lastName);

    public Optional<User> findByFirstName(String firstName);

    public List<User> findAll();

    public Optional<User> findByEmail(String email);
}
