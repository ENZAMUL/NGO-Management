package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface LoanTypeRepo extends JpaRepository<LoanType, Long> {

    //finding by typeName
    LoanType findByTypeName(String typeName);

    boolean existsLoanTypeByTypeName(String typeName);
}
