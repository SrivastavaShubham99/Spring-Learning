package guru.springframework.spring6restmvc.model.embeddables;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaLinks {

    private String twitter;
    private String linkedin;
    private String facebook;
    private String instagram;
}
