package be.pxl.services.controller;

import be.pxl.services.domain.dto.organization.OrgResWithDepAndEmp;
import be.pxl.services.domain.dto.organization.OrgResWithDepartments;
import be.pxl.services.domain.dto.organization.OrgResWithEmployees;
import be.pxl.services.domain.dto.organization.OrganizationResponse;
import be.pxl.services.services.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final IOrganizationService organizationService;

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponse> getOrganizationById(@PathVariable long id) {
        return new ResponseEntity<>(organizationService.getOrganizationById(id), HttpStatus.OK);
    }


    @GetMapping("/{id}/with-departments")
    public ResponseEntity<OrgResWithDepartments> getOrganizationByIdWithDep(@PathVariable long id) {
        return new ResponseEntity<>(organizationService.getOrganizationByIdWithDep(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity<OrgResWithDepAndEmp> getOrganizationByIdWithDepAndEmp(@PathVariable long id) {
        return new ResponseEntity<>(organizationService.getOrganizationByIdWithDepAndEmp(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-employees")
    public ResponseEntity<OrgResWithEmployees> getOrganizationByIdWithEmp(@PathVariable long id) {
        return new ResponseEntity<>(organizationService.getOrganizationByIdWithEmp(id), HttpStatus.OK);
    }
}
