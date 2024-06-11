package guru.springframework.spring6restmvc.services.service_impl;

import guru.springframework.spring6restmvc.entities.Lesson;
import guru.springframework.spring6restmvc.mapper.LessonMapper;
import guru.springframework.spring6restmvc.model.LessonDTO;
import guru.springframework.spring6restmvc.repositories.LessonRepository;
import guru.springframework.spring6restmvc.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LessonServiceImpl implements LessonService {

    LessonRepository lessonRepository;

    @Autowired
    LessonMapper lessonMapper;

    LessonServiceImpl(LessonRepository lessonRepository){
        this.lessonRepository=lessonRepository;
    }

    @Override
    public LessonDTO saveLesson(Lesson lesson) {
        boolean isExists=lessonRepository.
                existsByCourseIdAndLessonOrder(
                        lesson.getCourse().getId(),
                        lesson.getLessonOrder());
        LessonDTO lessonDTO=new LessonDTO();
        if(isExists){
            lessonDTO.setAlreadyExists(true);
        }else{
            Lesson lesson1=lessonRepository.save(lesson);
            lessonDTO=lessonMapper.lessonToLessonDTO(lesson1);
        }
        return lessonDTO;

    }
}
