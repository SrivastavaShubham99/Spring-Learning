package guru.springframework.spring6restmvc.controller;


import guru.springframework.spring6restmvc.entities.Lesson;
import guru.springframework.spring6restmvc.model.LessonDTO;
import guru.springframework.spring6restmvc.model.MessageResponse;
import guru.springframework.spring6restmvc.services.service_impl.LessonServiceImpl;
import guru.springframework.spring6restmvc.utility.constants.ApiEndPoints;
import guru.springframework.spring6restmvc.utility.constants.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiEndPoints.lessonEndPoint)
public class LessonController {


    @Autowired
    LessonServiceImpl lessonService;

    @PostMapping
    public ResponseEntity<MessageResponse> saveLessonToCourse(@RequestBody Lesson lesson){

        LessonDTO lessonDTO=lessonService.saveLesson(lesson);
        MessageResponse messageResponse;
        if(lessonDTO.isAlreadyExists()){
            messageResponse=MessageResponse
                    .builder()
                    .message(Messages.orderAlreadyExistsWithCourse)
                    .build();
        }else{
            messageResponse=MessageResponse
                    .builder()
                    .message(Messages.lessonAddMessage)
                    .build();
        }


        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);

    }
}
