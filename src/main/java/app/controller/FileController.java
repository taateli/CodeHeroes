
package app.controller;

import app.domain.FileObject;
import app.domain.Reference;
import app.service.FileService;
import app.service.ReferenceService;
import app.service.UtilityService;
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

/**
 * This class handles all requests regarding to downloading references as a .bib
 * file.
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
    private UtilityService validator;

    /**
     * Method to download a BibTex file
     * @param fileName, String, name of the file
     * @param refs, Long [], contains ids of the references to download
     * @return 
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> viewFile(@RequestParam String fileName, @RequestParam(name = "refs", required = false) Long[] refs) {

        String name = fileName;
        if (!validator.fieldNotEmpty(fileName)) {
            name = null;
        }

        List<Reference> toDownload = new ArrayList<>();
        if (refs == null || refs[0] == null) {
            toDownload = referenceService.getReferences();
        } else {
            toDownload = referenceService.getReferencesById(Arrays.asList(refs));
        }

        FileObject fo = fileService.createFile(toDownload, name);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/bib"));
        headers.add("Content-Disposition", "attachment; filename=" + fo.getName());
        headers.setContentLength(fo.getContentLength());

        return new ResponseEntity<byte[]>(fo.getContent(), headers, HttpStatus.CREATED);
    }

}
