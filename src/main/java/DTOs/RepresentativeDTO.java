package DTOs;

import lombok.*;

@Value
@AllArgsConstructor
@Getter
@NonNull
public class RepresentativeDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String patronimic;
    private int university;
}
