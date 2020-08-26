package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Employee;
import com.enzamul.ngoProjects.entity.LoanCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface LoanCollectionRepo extends JpaRepository<LoanCollection, Long> {

    //finding by Employee
    LoanCollection findByEmployee(Employee employee);

    boolean existsLoanCollectionByEmployee(Employee employee);
}
