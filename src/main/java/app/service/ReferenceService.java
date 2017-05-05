package app.service;

import app.domain.Reference;
import app.repository.ReferenceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * This class gives service to controller class and detaches database operations
 * from controller
 *
 */
@Service
public class ReferenceService {

    @Autowired
    private ReferenceRepository refRepository;

    @Autowired
    private WebCrawler crawler;

    /**
     * This method handles turning acm link to a real reference
     *
     * @param url String url to an CM reference
     * @return Reference from ACM
     * @throws InterruptedException if interrupted
     */
    public Reference getReferencesFromAcm(String url) throws InterruptedException {
        return crawler.getReference(url);
    }

    /**
     * This method handles saving References to database via repository
     *
     * @param reference Reference being added
     * @return Reference saved
     */
    public Reference addReference(Reference reference) {
        return refRepository.save(reference);
    }

    /**
     * This method handles getting all References from database via repository
     *
     * @return all References from refRepository
     */
    public List<Reference> getReferences() {
        return refRepository.findAll();
    }

    /**
     * Method that compares given String search to String toString of all
     * references in the database and returns List of references including the
     * String search
     *
     * @param search String being searched
     * @return references containing searched String
     */
    public List<Reference> getSearchedReferences(String search) {
        List<Reference> allRefs = refRepository.findAll();
        List<Reference> returnRefs = new ArrayList<Reference>();
        for (Reference ref : allRefs) {
            if (ref.toString().contains(search)) {
                returnRefs.add(ref);
            }
        }
        return returnRefs;
    }

    /**
     * Deletes a reference from ReferenceRepository according to its id
     *
     * @param id Long id of the reference being deleted
     */
    public void delete(Long id) {
        refRepository.delete(id);
    }

    /**
     * Finds a reference from ReferenceRepository according to its id
     *
     * @param id Long id of the reference being searched
     * @return reference with the id
     */
    public Reference findById(Long id) {
        return refRepository.findById(id);
    }

    /**
     * Finds a reference from ReferenceRepository according to its key
     *
     * @param key String key of the reference being searched
     * @return reference with the searched key
     */
    public Reference findByKey(String key) {
        return refRepository.findByKey(key);
    }

    /**
     * Creates a list of references based on a list containing ids
     *
     * @param ids List of ids being searched
     * @return List of references with searched ids
     */
    public List<Reference> getReferencesById(List<Long> ids) {
        List refs = new ArrayList<>();
        for (Long id : ids) {
            refs.add(this.findById(id));
        }
        return refs;
    }
}
