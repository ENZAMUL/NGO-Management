package com.enzamul.ngoProjects.repo;

import com.enzamul.ngoProjects.entity.CollectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Repository
public interface CollectionTypeRepo extends JpaRepository<CollectionType, Long> {

    //finding by typeName
    CollectionType findByTypeName(String typeName);

    boolean existsCollectionTypeByTypeName(String typeName);

}
