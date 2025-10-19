package be.pxl.services.services;

import be.pxl.services.domain.dto.organization.OrgResWithDepAndEmp;
import be.pxl.services.domain.dto.organization.OrgResWithDepartments;
import be.pxl.services.domain.dto.organization.OrgResWithEmployees;
import be.pxl.services.domain.dto.organization.OrganizationResponse;

public interface IOrganizationService {
    OrganizationResponse getOrganizationById(long id);
    OrgResWithDepartments getOrganizationByIdWithDep(long id);
    OrgResWithDepAndEmp getOrganizationByIdWithDepAndEmp(long id);
    OrgResWithEmployees getOrganizationByIdWithEmp(long id);
}
