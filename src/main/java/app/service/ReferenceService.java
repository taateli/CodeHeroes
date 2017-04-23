
package app.service;


import app.domain.Reference;
import app.repository.ReferenceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    This class gives service to controller class and detachs database operations from controller

*/

@Service
public class ReferenceService {
    
    @Autowired
    private ReferenceRepository refRepository;
    
    public Reference addReference(Reference b){

        return refRepository.save(b);
    }
    
    
    public List<Reference> getReferences() {
        
        return refRepository.findAll();  
    } 
    
    public void delete(Long id) {
        refRepository.delete(id);
    }
    
    public Reference findById (Long id) {
        return refRepository.findById(id);
    }
    
    public Reference findByKey (String key) {
        return refRepository.findByKey(key);
    }

}
