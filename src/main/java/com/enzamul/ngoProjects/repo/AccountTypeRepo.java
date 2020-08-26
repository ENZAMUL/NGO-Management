package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType, Long> {

    //finding by typeName
    AccountType findByTypeName(String typeName);

    boolean existsAccountTypeByTypeName(String typeName);

}
