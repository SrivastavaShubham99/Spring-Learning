package guru.springframework.spring6restmvc.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import guru.springframework.spring6restmvc.model.embeddables.Address;
import guru.springframework.spring6restmvc.model.embeddables.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Profile profile;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;
}
