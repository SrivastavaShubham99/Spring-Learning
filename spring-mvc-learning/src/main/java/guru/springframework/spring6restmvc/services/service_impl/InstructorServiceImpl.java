package guru.springframework.spring6restmvc.services.service_impl;

import guru.springframework.spring6restmvc.entities.Instructor;
import guru.springframework.spring6restmvc.repositories.InstructorRepository;
import guru.springframework.spring6restmvc.services.InstructorService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class InstructorServiceImpl implements InstructorService {

    InstructorRepository instructorRepository;


    InstructorServiceImpl(InstructorRepository instructorRepository){
        this.instructorRepository=instructorRepository;
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorRepository.deleteById(id);
    }


    @Override
    public List<Instructor> findInstructorsByCourseId(Long courseId) {
        return instructorRepository.findByCourseId(courseId);
    }
}
