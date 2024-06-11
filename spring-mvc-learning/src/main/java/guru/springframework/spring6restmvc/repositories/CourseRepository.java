package guru.springframework.spring6restmvc.repositories;



import guru.springframework.spring6restmvc.entities.Course;
import guru.springframework.spring6restmvc.entities.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CourseRepository {

    @Autowired
    EntityManager em;


    // find the course by particular id
    public Course findById(Long id){
        return em.find(Course.class,id);
    }

    //delete course by id
    public void deleteById(Long id){
        Course course=findById(id);
        em.remove(course);
    }


    //save or update course
    public Course saveUpdateCourse(Course course){
        // if the course id is null indicates that
        // it will be fresh course entry in DB.

//        for(Instructor instructor : course.getInstructors()){
//            instructor.setCourse(course);
//        }
//
        if(course.getId()==null){
            em.persist(course);
        }else{
            em.merge(course);
        }

        return course;
    }
}
