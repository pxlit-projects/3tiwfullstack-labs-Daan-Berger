package be.pxl.services.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequest {
    @NotNull
    private Long organizationId;
    @NotNull
    private Long departmentId;
    @NotBlank
    private String name;
    @NotNull
    private int age;
    @NotNull
    private String position;
}
