package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    public void deleteById(Long id);

    public List<Instructor> findByCourseId(Long courseId);
}
