package be.pxl.services.services;

import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.domain.dto.DepartmentResponseWithEmployees;

import java.util.List;

public interface IDepartmentService {
    void addDepartment(DepartmentRequest departmentRequest);

    DepartmentResponse getDepartmentById(long id);

    List<DepartmentResponse> getAllDepartments();

    List<DepartmentResponse> getAllDepartmentsByOrganization(long id);

    List<DepartmentResponseWithEmployees> getAllDepartmentsByOrganizationWithEmployees(long id);
}
