package app.service;

import app.domain.Reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * This class is helper class for validating inputs and other helper methods
 */
@Service
public class ValidatorService {
    
    @Autowired
    private ReferenceService refService;

    /**
     * This method checks if input string is empty
     *
     * @param value
     * @return
     */
    public boolean fieldNotEmpty(String value) {
        return value.length() > 0;
    }

    /**
     * This method checks if with two string parameter converted to integers,
     * end is smaller than start
     *
     * @param end
     * @param start
     * @return
     */
    public boolean endingPageBeforeStartingPage(String end, String start) {
        return Integer.parseInt(end) < Integer.parseInt(start);
    }

    /**
     * This method is for splitting authors (String) to an ArrayList
     *
     * @param authors
     * @return
     */
    public List<String> splitAuthors(String authors) {
        List authorList = new ArrayList<>(Arrays.asList(authors.split(" and ")));
        return authorList;
    }

    /**
     * This method is for splitting tags (String) to an ArrayList
     *
     * @param tags
     * @return
     */
    public List<String> splitTags(String tags) {
        List authorList = new ArrayList<>(Arrays.asList(tags.split(", ")));
        return authorList;
    }

    /**
     * This method generates a key for a reference if the user has not given a
     * key value
     *
     * @param ref
     * @return
     */
    public Reference getKey(Reference ref) {
        String key = "";

        if (ref.getAuthors().get(0).contains(" ")) {
            String[] auth = ref.getAuthors().get(0).split(" ");
            key = key + auth[0].charAt(0);

            if (auth[1].length() > 0) {
                key = key + auth[1].charAt(0);
            }

        } else {
            key = key + ref.getAuthors().get(0).charAt(0);
        }
        key = key + ref.getYear();
       
        key = findNumberForKey(key);
        
        ref.setKey(key);

        return ref;
    }

    private String findNumberForKey(String key) {
        if (refService.findByKey(key) != null) {
            key = key + "-";
            int counter = 1;
            String temp = key + counter;
            
            while (refService.findByKey(temp) != null) {
                counter++;
                temp = key + counter;
                
            }
            key = key + counter;
        }
        return key;
    }

}
