package guru.springframework.spring6restmvc.repositories.accounting;

import guru.springframework.spring6restmvc.entities.accounting.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public Boolean existsByFirstNameAndLastName(String firstName,String lastName);
}
