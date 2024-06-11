package guru.springframework.spring6restmvc.mapper;

import guru.springframework.spring6restmvc.entities.Lesson;
import guru.springframework.spring6restmvc.model.LessonDTO;
import org.mapstruct.Mapper;


@Mapper
public interface LessonMapper {

    public LessonDTO lessonToLessonDTO(Lesson lesson);

    public Lesson lessonDTOToLesson(LessonDTO lessonDTO);
}
