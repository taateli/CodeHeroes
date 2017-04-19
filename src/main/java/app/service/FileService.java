/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public FileObject createFile(List<Reference> references, String fileName) {
        
        String content = "";
        String checked;
        for (Reference ref : references) {
            checked = ref.toBibTex();
            checked = letterChecker.changeScandisToBibTextForm(checked);
            content += checked +"\n";  //vaihdetaan kun bibtex-metodi toimii
           //content += = ref.toBibtex()+"\n";
  
        }
        return new FileObject(content.getBytes(),fileName);
    }
    
}
