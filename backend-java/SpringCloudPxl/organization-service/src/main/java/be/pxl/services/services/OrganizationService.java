package be.pxl.services.services;

import be.pxl.services.domain.dto.organization.OrgResWithDepAndEmp;
import be.pxl.services.domain.dto.organization.OrgResWithDepartments;
import be.pxl.services.domain.dto.organization.OrgResWithEmployees;
import be.pxl.services.domain.dto.organization.OrganizationResponse;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService implements IOrganizationService {

    @Override
    public OrganizationResponse getOrganizationById(long id) {
        return null;
    }

    @Override
    public OrgResWithDepartments getOrganizationByIdWithDep(long id) {
        return null;
    }

    @Override
    public OrgResWithDepAndEmp getOrganizationByIdWithDepAndEmp(long id) {
        return null;
    }

    @Override
    public OrgResWithEmployees getOrganizationByIdWithEmp(long id) {
        return null;
    }
}
