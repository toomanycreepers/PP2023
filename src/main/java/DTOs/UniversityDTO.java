package DTOs;

import lombok.*;

@Value
@AllArgsConstructor
@Getter
@NonNull
public class UniversityDTO {
    private int id;
    private String name;
}
