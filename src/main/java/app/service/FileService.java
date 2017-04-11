/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.domain.FileObject;
import app.domain.Reference;
import java.util.List;
import org.springframework.stereotype.Service;

/**Creates a file object of all references
 *
 * @author kaisa
 */

@Service
public class FileService {

    public FileObject createFile(List<Reference> references) {
        
        String content = "";
        for (Reference ref : references) {
            content += ref.toString()+"\n";  //vaihdetaan kun bibtex-metodi toimii
           //content += = ref.toBibtex()+"\n";
  
        }
        return new FileObject(content.getBytes(),"testifile");
    }
    
}
