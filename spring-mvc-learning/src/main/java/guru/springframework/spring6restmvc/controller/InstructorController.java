package guru.springframework.spring6restmvc.controller;


import guru.springframework.spring6restmvc.entities.Instructor;
import guru.springframework.spring6restmvc.services.service_impl.InstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {


    @Autowired
    InstructorServiceImpl instructorService;

    @PostMapping
    public Instructor addInstructors(@RequestBody  Instructor instructor){
        instructorService.saveInstructor(instructor);
        return instructor;
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity deleteInstructorById(@PathVariable("instructorId") Long id){
        instructorService.deleteInstructorById(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{courseId}")
    public List<Instructor> getInstructorsByCourseId(@PathVariable("courseId") Long id){
        return instructorService.findInstructorsByCourseId(id);
    }
}
