package DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
@Getter
@NonNull
public class GraduateAuthDTO {
    private String mail;
    private String password;
}
