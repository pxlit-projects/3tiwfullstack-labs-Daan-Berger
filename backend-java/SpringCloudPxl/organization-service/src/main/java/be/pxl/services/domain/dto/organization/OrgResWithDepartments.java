package be.pxl.services.domain.dto.organization;

import be.pxl.services.domain.dto.department.DepartmentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrgResWithDepartments {
    private Long id;
    private String name;
    private String address;
    private List<DepartmentResponse> departments;
}
