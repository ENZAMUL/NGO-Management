package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.DepositType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface DepositTypeRepo extends JpaRepository<DepositType, Long> {

    //finding by typeName
    DepositType findByTypeName(String typeName);

    boolean existsDepositTypeByTypeName(String typeName);
}
