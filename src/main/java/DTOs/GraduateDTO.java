package DTOs;

import lombok.*;

@Value
@AllArgsConstructor
@Getter
@NonNull
public class GraduateDTO {
    private long id;
    private String mail;
    private String firstname;
    private String lastname;
    private String patronimic;
    private String dateOfBirthday;
    private String gradFrom;
    private String region;
}
