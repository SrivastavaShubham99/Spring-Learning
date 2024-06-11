package guru.springframework.spring6restmvc.model.embeddables;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    private String username;
    private String fullName;
    private String emailAddress;
    private String phoneNumber;
    private String dateOfBirth;
    private String gender;
    private String bio;
    private String profilePicture;
    private String location;
    private String website;
    @Embedded
    private SocialMediaLinks socialMediaLinks;
    private String education;
    private String employment;
    private String interests;
    private String skills;
    private String languages;
}
