package com.example.Module2HomeWork.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 50)
    private String title;

    @NotNull(message = "isActive cannot be null")
    private Boolean isActive;
}
