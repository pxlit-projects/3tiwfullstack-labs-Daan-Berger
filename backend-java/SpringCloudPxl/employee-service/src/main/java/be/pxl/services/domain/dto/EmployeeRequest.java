package be.pxl.services.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
