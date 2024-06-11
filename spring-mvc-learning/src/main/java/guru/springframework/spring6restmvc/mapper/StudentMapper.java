package guru.springframework.spring6restmvc.mapper;


import guru.springframework.spring6restmvc.entities.Student;
import guru.springframework.spring6restmvc.model.StudentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {
    StudentDTO studentToStudentDTO(Student student);

    Student studentDTOToStudent(StudentDTO studentDTO);
}
