package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.entities.Instructor;

import java.util.List;

public interface InstructorService {

    public Instructor saveInstructor(Instructor instructor);

    public void deleteInstructorById(Long id);

    public List<Instructor> findInstructorsByCourseId(Long courseId);
}
