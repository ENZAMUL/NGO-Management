package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

//finding by roleNome
    Role findByRoleName(String roleName);

    boolean existsRoleByRoleName(String roleName);
}
