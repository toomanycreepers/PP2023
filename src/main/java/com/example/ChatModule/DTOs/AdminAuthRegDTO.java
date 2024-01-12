package com.example.ChatModule.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminAuthRegDTO {
    @NotBlank
    @Pattern(regexp = "^admin_\\w*")
    private String name;

    @NotBlank
    @Size(min = 8,max = 32)
    private String password;
}
