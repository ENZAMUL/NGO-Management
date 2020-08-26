package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {

    //  finding by branchName or branchCode
    Optional<Branch> findByBranchNameOrBranchCode(String branchName, String branchCode);

    Branch findByBranchName(String branchName);

    boolean existsByBranchCode(String branchCode);

}
