package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.entities.Lesson;
import guru.springframework.spring6restmvc.model.LessonDTO;

public interface LessonService {

    public LessonDTO saveLesson(Lesson lesson);
}
