package guru.springframework.spring6restmvc.model;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LessonDTO {

    private String title;
    private String description;
    private int order;
    private boolean alreadyExists;
}
