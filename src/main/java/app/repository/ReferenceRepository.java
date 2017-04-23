
package app.repository;

import app.domain.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

/*  This class handles the database connection


*/

public interface ReferenceRepository extends JpaRepository<Reference,Long> {
   
    Reference findById(Long id);
    
    Reference findByKey(String key);
}

