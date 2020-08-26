package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    //  finding by  accountHolderName or  accountCodeNumber
    Optional<Account> findByAccountHolderNameOrAccountCodeNumber(String accountHolderName, String accountCodeNumber);

    Account findByAccountHolderName(String accountHolderName);

    boolean existsByAccountCodeNumber(String accountCodeNumber);
}
