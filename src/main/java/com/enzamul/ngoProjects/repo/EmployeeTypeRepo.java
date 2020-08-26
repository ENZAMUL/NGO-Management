package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface EmployeeTypeRepo extends JpaRepository<EmployeeType, Long> {

    //finding by empType
//Optional<EmployeeType> findByTypeName(String typeName);
    EmployeeType findByTypeName(String typeName);

    boolean existsEmployeeTypeByTypeName(String typeName);

}
