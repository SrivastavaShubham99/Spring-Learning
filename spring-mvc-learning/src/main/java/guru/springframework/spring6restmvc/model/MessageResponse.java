package guru.springframework.spring6restmvc.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class MessageResponse {

    private String message;
}
