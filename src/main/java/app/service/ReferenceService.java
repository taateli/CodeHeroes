
package app.service;


import app.domain.Reference;
import app.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceService {
    
    @Autowired
    private ReferenceRepository refRepository;
    
    public Reference addBookReference(Reference b){

        return refRepository.save(b);
    }

}
