package be.pxl.services.services;

import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;
import be.pxl.services.domain.Employee;
import be.pxl.services.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeResponse::new)
                .toList();
    }

    @Override
    public void addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .organizationId(employeeRequest.getOrganizationId())
                .departmentId(employeeRequest.getDepartmentId())
                .name(employeeRequest.getName())
                .age(employeeRequest.getAge())
                .position(employeeRequest.getPosition())
                .build();

        employeeRepository.save(employee);
    }

    @Override
    public EmployeeResponse getEmployeeById(long id) {

        return employeeRepository.findById(id)
                .stream()
                .map(EmployeeResponse::new)
                .findAny().get();
    }

    @Override
    public List<EmployeeResponse> getEmployeeByDepartmentId(long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId)
                .stream()
                .map(EmployeeResponse::new)
                .toList();
    }

    @Override
    public List<EmployeeResponse> getEmployeeByOrganizationId(long organizationId) {
        return employeeRepository.findByOrganizationId(organizationId)
                .stream()
                .map(EmployeeResponse::new)
                .toList();
    }
}
