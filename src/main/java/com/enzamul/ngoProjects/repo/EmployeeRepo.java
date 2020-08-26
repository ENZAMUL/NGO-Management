package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    //  finding by  employeeName or  employeeCode
    Optional<Employee> findByEmployeeNameOrEmployeeCode(String employeeName, String employeeCode);

    Employee findByEmployeeName(String employeeName);

    boolean existsByEmployeeCode(String employeeCode);

}
