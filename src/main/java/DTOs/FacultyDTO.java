package DTOs;

import lombok.*;

import java.util.List;

@Value
@AllArgsConstructor
@Getter
@NonNull
public class FacultyDTO {
    private long id;
    private int university;
    private List<EduProgramDTO> EPs;
}
