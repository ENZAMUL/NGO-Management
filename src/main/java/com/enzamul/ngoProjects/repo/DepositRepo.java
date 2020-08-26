package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface DepositRepo extends JpaRepository<Deposit, Long> {

    //  finding by depositBranch
    // Optional<Deposit> findByDepositBranch(String depositBranch);
//    Deposit findByDepositBranch(String depositBranch);

    boolean existsByLoanCodeNumber(Long loanCodeNumber);
}
