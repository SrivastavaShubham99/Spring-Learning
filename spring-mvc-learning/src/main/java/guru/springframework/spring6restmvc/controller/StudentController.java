package guru.springframework.spring6restmvc.controller;


import guru.springframework.spring6restmvc.entities.Student;
import guru.springframework.spring6restmvc.services.service_impl.StudentServiceImpl;
import guru.springframework.spring6restmvc.utility.constants.ApiEndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiEndPoints.studentsEndPoint)
public class StudentController {


    @Autowired
    StudentServiceImpl studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }
}
