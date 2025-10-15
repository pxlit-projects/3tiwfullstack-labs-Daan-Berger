package be.pxl.services.services;

import be.pxl.services.controller.dto.EmployeeRequest;
import be.pxl.services.controller.dto.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponse> getAllEmployees();

    void addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse getEmployeeById(long id);

    List<EmployeeResponse> getEmployeeByDepartmentId(long id);

    List<EmployeeResponse> getEmployeeByOrganizationId(long id);
}
