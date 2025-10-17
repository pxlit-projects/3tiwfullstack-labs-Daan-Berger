package be.pxl.services.controller;

import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.domain.dto.DepartmentResponseWithEmployees;
import be.pxl.services.services.IDepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final IDepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addDepartment(@Valid @RequestBody DepartmentRequest departmentRequest) {
        departmentService.addDepartment(departmentRequest);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable long id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("organization/{organizationId}")
    public ResponseEntity<List<DepartmentResponse>> getDepartmentsByOrganization(@PathVariable  long organizationId) {
        return new ResponseEntity<>(departmentService.getAllDepartmentsByOrganization(organizationId), HttpStatus.OK);
    }

    @GetMapping("organization/{organizationId}/with-employees")
    public ResponseEntity<List<DepartmentResponseWithEmployees>> getDepartmentsByOrganizationWithEmployees(@PathVariable long organizationId) {
        return new ResponseEntity<>(departmentService.getAllDepartmentsByOrganizationWithEmployees(organizationId), HttpStatus.OK);
    }
}
