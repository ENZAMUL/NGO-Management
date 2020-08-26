package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface NomineeRepo extends JpaRepository<Nominee, Long> {

    //finding by roleNome
    Nominee findByNomineeName(String nomineeName);

    boolean existsRoleByNomineeName(String nomineeName);
}
