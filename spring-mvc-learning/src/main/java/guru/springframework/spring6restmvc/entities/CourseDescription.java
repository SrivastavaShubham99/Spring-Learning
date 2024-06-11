package guru.springframework.spring6restmvc.entities;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDescription {

    private String courseBriefDesc;

    private String courseExtendedDesc;

    @ElementCollection
    @Lob
    private List<String> courseSyllabus;

    private boolean isActive;

    private String flag;
}
