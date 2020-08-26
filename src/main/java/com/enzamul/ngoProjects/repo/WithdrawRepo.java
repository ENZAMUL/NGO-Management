package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Account;
import com.enzamul.ngoProjects.entity.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface WithdrawRepo extends JpaRepository<Withdraw, Long> {

    //finding by account
    Withdraw findByAccount(Account account);

    boolean existsWithdrawByAccount(Account account);
}
