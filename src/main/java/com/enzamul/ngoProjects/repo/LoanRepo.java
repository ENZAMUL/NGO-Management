package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {

    //  finding by loanCodeNumber
    Loan findByLoanCodeNumber(String loanCodeNumber);

    boolean existsByLoanCodeNumber(String loanCodeNumber);
}
