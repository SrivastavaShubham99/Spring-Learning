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
public class Address {

    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
    private String country;

}
