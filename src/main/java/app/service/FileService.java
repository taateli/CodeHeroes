
package app.service;

import app.domain.FileObject;
import app.domain.Reference;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**Creates a file object of all references
 *
 * @author kaisa
 */

@Service
public class FileService {
    
    
    @Autowired
    private LetterChecker letterChecker;
    
    /**
     * Creates a FileObject containing with references in a String and the name of the file
     * @param references, a list containing selected references
     * @param fileName, String, name of the file
     * @return a FileObject containing references with Scandinavian letters in BibTex form, and the name of the file
     */
    public FileObject createFile(List<Reference> references, String fileName) {
        
        String content = "";
        String checked;
        for (Reference ref : references) {
            checked = ref.toBibTex();
            checked = letterChecker.changeScandisToBibTextForm(checked);
            content += checked +"\n";  
  
        }
        return new FileObject(content.getBytes(),fileName);
    }
    
}
