package be.pxl.services.services;

import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponse> getAllEmployees();

    void addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse getEmployeeById(long id);

    List<EmployeeResponse> getEmployeeByDepartmentId(long id);

    List<EmployeeResponse> getEmployeeByOrganizationId(long id);
}
