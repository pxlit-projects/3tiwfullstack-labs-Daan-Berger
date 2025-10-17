package be.pxl.services.domain.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponseWithEmployees {
    private Long id;
    private Long organizationId;
    private String name;
    private List<EmployeeResponse> employees;
    private String position;
}
