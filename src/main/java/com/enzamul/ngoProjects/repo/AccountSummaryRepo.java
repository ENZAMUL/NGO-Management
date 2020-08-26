package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Account;
import com.enzamul.ngoProjects.entity.AccountSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface AccountSummaryRepo extends JpaRepository<AccountSummary, Long> {

    //finding by account
    AccountSummary findByAccount(Account account);

    boolean existsAccountSummaryByAccount(Account account);

}
