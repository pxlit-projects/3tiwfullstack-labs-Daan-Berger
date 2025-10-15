package be.pxl.services.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private Long organizationId;
    private String name;
    private Integer age;
    private String position;
}
