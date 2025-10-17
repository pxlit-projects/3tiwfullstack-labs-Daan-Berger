package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.*;
import be.pxl.services.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService{

    private final DepartmentRepository departmentRepository;

    @Override
    public void addDepartment(DepartmentRequest departmentRequest) {
        List<Employee> employees = departmentRequest.getEmployees()
                .stream()
                .map(this::mapToEmployee)
                .toList();

        Department department = Department.builder()
                .organizationId(departmentRequest.getOrganizationId())
                .name(departmentRequest.getName())
                .employees(employees)
                .position(departmentRequest.getPosition())
                .build();

        departmentRepository.save(department);
    }

    @Override
    public DepartmentResponse getDepartmentById(long id) {
        Department department = departmentRepository.findById(id).get();
        return mapToDepartmentResponse(department);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.
                stream()
                .map(this::mapToDepartmentResponse)
                .toList();
    }

    @Override
    public List<DepartmentResponse> getAllDepartmentsByOrganization(long id) {
        List<Department> departments = departmentRepository.findByOrganizationId(id);
        return departments
                .stream()
                .map(this::mapToDepartmentResponse)
                .toList();
    }

    @Override
    public List<DepartmentResponseWithEmployees> getAllDepartmentsByOrganizationWithEmployees(long id) {
        List<Department> departments = departmentRepository.findByOrganizationId(id);
        return departments
                .stream()
                .map(this::mapToDepartmentResponseWithEmployees)
                .toList();
    }

    private DepartmentResponse mapToDepartmentResponse(Department department) {
        return DepartmentResponse.builder()
                .id(department.getId())
                .organizationId(department.getOrganizationId())
                .name(department.getName())
                .position(department.getPosition())
                .build();
    }

    private DepartmentResponseWithEmployees mapToDepartmentResponseWithEmployees(Department department) {
        List<EmployeeResponse> employeeResponse = department.getEmployees()
                .stream()
                .map(e -> new EmployeeResponse(
                        e.getId(), e.getOrganizationId(), e.getName(), e.getAge(), e.getPosition())
                ).toList();

        return DepartmentResponseWithEmployees.builder()
                .id(department.getId())
                .organizationId(department.getOrganizationId())
                .name(department.getName())
                .employees(employeeResponse)
                .position(department.getPosition())
                .build();
    }

    private Employee mapToEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .organizationId(employeeRequest.getOrganizationId())
                .name(employeeRequest.getName())
                .age(employeeRequest.getAge())
                .position(employeeRequest.getPosition())
                .build();
    }
}
