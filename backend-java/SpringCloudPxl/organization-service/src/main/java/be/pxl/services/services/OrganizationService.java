package be.pxl.services.services;

import be.pxl.services.domain.Organization;
import be.pxl.services.domain.dto.department.DepartmentResponse;
import be.pxl.services.domain.dto.employee.EmployeeResponse;
import be.pxl.services.domain.dto.organization.OrgResWithDepAndEmp;
import be.pxl.services.domain.dto.organization.OrgResWithDepartments;
import be.pxl.services.domain.dto.organization.OrgResWithEmployees;
import be.pxl.services.domain.dto.organization.OrganizationResponse;
import be.pxl.services.repository.OrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationResponse getOrganizationById(long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        return OrganizationResponse.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .build();
    }

    @Override
    @Transactional()
    public OrgResWithDepartments getOrganizationByIdWithDep(long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        List<DepartmentResponse> departments = organization.getDepartments()
                .stream()
                .map(d -> new DepartmentResponse(
                        d.getId(), d.getName(), d.getPosition()))
                .toList();

        return OrgResWithDepartments.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .departments(departments)
                .build();
    }

    @Override
    @Transactional
    public OrgResWithDepAndEmp getOrganizationByIdWithDepAndEmp(long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        List<DepartmentResponse> departments = organization.getDepartments()
                .stream()
                .map(d -> new DepartmentResponse(
                        d.getId(), d.getName(), d.getPosition()))
                .toList();

        List<EmployeeResponse> employees = organization.getEmployees()
                .stream()
                .map(e -> new EmployeeResponse(
                        e.getId(), e.getName(), e.getAge(), e.getPosition()))
                .toList();

        return OrgResWithDepAndEmp.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .departments(departments)
                .employees(employees)
                .build();
    }

    @Override
    @Transactional
    public OrgResWithEmployees getOrganizationByIdWithEmp(long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        List<EmployeeResponse> employees = organization.getEmployees()
                .stream()
                .map(e -> new EmployeeResponse(
                        e.getId(), e.getName(), e.getAge(), e.getPosition()))
                .toList();

        return OrgResWithEmployees.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .employees(employees)
                .build();
    }
}
