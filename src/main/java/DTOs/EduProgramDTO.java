package DTOs;

import lombok.Getter;
import lombok.Value;

import java.util.List;

@Value
public class EduProgramDTO {
    private String id;
    private String name;
    private List<Long> faculty; // потом подумаем
}
