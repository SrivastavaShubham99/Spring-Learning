package guru.springframework.spring6restmvc.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import guru.springframework.spring6restmvc.model.embeddables.Address;
import guru.springframework.spring6restmvc.model.embeddables.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @Embedded
    private Profile profile;

    @ManyToMany(mappedBy = "students")
    @JsonBackReference
    private Set<Course> courseList=new HashSet<>();
}
