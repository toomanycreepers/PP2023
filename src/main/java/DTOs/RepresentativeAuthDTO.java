package DTOs;

import lombok.*;

@Value
@AllArgsConstructor
@Getter
@NonNull
public class RepresentativeAuthDTO {
    private String login;
    private String password;
}
