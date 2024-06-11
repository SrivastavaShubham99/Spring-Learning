package guru.springframework.spring6restmvc.services.service_impl;

import guru.springframework.spring6restmvc.entities.Course;
import guru.springframework.spring6restmvc.entities.Student;
import guru.springframework.spring6restmvc.repositories.CourseRepository;
import guru.springframework.spring6restmvc.repositories.StudentRepository;
import guru.springframework.spring6restmvc.services.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;
    CourseRepository courseRepository;

    StudentServiceImpl(StudentRepository studentRepository,CourseRepository courseRepository){
        this.studentRepository=studentRepository;
        this.courseRepository=courseRepository;
    }
    @Override
    public Student saveStudent(Student student) {

        Set<Course> courses=new HashSet<>();


        for(Course course : student.getCourseList()){
            Course courseRes=courseRepository.findById(course.getId());
            if(courseRes.getStudents()==null){
                courseRes.setStudents(new HashSet<>());
            }
            courseRes.getStudents().add(student);
            courses.add(courseRes);
        }

        student.setCourseList(courses);

        // before saving the data into the student we have
        studentRepository.save(student);
        return student;
    }
}
