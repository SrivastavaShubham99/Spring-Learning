package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
    public boolean existsByCourseIdAndLessonOrder(Long courseId,int lessonOrder);
}
