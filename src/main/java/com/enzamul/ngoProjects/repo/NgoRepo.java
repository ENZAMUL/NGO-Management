package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.Ngo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface NgoRepo extends JpaRepository<Ngo, Long> {

    Ngo findByName(String name);

}
