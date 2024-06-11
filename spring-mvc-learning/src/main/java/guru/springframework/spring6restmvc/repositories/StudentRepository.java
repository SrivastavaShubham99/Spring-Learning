package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
