/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.domain.FileObject;
import app.domain.Reference;
import app.service.FileService;
import app.service.ReferenceService;
import app.service.ValidatorService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/** This class handles all requests regarding to downloading references as a 
 *  .bib file.
 * 
 * @author kaisa
 */

@Controller
public class FileController {
    
    @Autowired
    private ReferenceService referenceService;
    
    @Autowired
    private FileService fileService;
    
    @Autowired
    private ValidatorService validator;
    
       @RequestMapping(value = "/download", method = RequestMethod.POST)
    public ResponseEntity<byte[]> viewFile(@RequestParam String fileName) {
        String name = fileName;
        if(!validator.fieldNotEmpty(fileName)){
            name = null;
        }
//        List<Reference> toDownload = new ArrayList<>();
//        if(refs.length > 0){
//            toDownload = referenceService.getReferencesById(Arrays.asList(refs));
//        }else{
//            toDownload = referenceService.getReferences();
//        }
        FileObject fo = fileService.createFile(referenceService.getReferences(),name);    

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/bib"));
        headers.add("Content-Disposition", "attachment; filename=" + fo.getName());
        headers.setContentLength(fo.getContentLength());

        return new ResponseEntity<byte[]>(fo.getContent(), headers, HttpStatus.CREATED);
    }

    //kopioitu malliksi, saa poistaa kun toimii
//    String filename = "output.pdf";
//    headers.setContentDispositionFormData(filename, filename);
//    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

}
