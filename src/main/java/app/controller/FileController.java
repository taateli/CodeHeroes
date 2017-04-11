/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.domain.FileObject;
import app.service.FileService;
import app.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
       @RequestMapping(value = "/references/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> viewFile(@PathVariable Long id) {
        FileObject fo = fileService.createFile(referenceService.getReferences());

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
