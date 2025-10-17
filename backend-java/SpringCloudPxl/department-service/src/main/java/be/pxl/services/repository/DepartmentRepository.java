package be.pxl.services.repository;

import be.pxl.services.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByOrganizationId(Long organizationId);

    @Query("select distinct d from Department d left join fetch d.employees e where d.organizationId = :organizationId")
    List<Department> findByOrganizationIdWithEmployees(@Param("organizationId") long organizationId);
}
