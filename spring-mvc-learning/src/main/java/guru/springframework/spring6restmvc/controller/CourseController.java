package guru.springframework.spring6restmvc.controller;


import guru.springframework.spring6restmvc.entities.Course;
import guru.springframework.spring6restmvc.entities.Student;
import guru.springframework.spring6restmvc.mapper.StudentMapper;
import guru.springframework.spring6restmvc.model.StudentDTO;
import guru.springframework.spring6restmvc.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
Transactional annotation will let us make changes in the DB.
Just like in the case of transferring money from one account
to another. There are 2 transactions taking place one is
account debited from one account and other is account is
credited to another.

 */
@RestController
@Transactional
public class CourseController {

    @Autowired
    CourseRepository courseRepository;


    @Autowired
    StudentMapper studentMapper;


    @GetMapping("/api/v1/course/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseRepository.findById(id);
    }


    @DeleteMapping("/api/v1/course/{id}")
    public void deleteCourseById(@PathVariable Long id){
        courseRepository.deleteById(id);
    }


    @PutMapping("/api/v1/course")
    public Course saveCourse(Course course){
        return courseRepository.saveUpdateCourse(course);
    }

    @PostMapping("/api/v1/course")
    public Course updateCourse(@RequestBody Course course){

        return courseRepository.saveUpdateCourse(course);
    }


    @GetMapping("/api/v1/course/students/{courseId}")
    public List<StudentDTO> getStudentListByCourseId(@PathVariable("courseId") Long id){
        Course course=getCourseById(id);
        return course.getStudents()
                .stream()
                .toList()
                .stream()
                .map( f -> studentMapper.studentToStudentDTO(f))
                .toList();
    }
}
