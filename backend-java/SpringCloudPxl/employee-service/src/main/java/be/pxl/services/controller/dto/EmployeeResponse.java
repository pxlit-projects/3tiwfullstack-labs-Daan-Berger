package be.pxl.services.controller.dto;

import be.pxl.services.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private Long organizationId;
    private Long departmentId;
    private String name;
    private Integer age;
    private String position;

    public EmployeeResponse(Employee employee) {
        this.id = employee.getId();
        this.organizationId = employee.getOrganizationId();
        this.departmentId = employee.getDepartmentId();
        this.name = employee.getName();
        this.age = employee.getAge();
        this.position = employee.getPosition();
    }
}
