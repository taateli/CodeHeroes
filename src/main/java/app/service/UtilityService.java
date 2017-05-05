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
public class UtilityService {

    @Autowired
    private ReferenceService refService;

    /**
     * This method checks if input pagenumbers (String,String) are ok
     *
     * @param end endingPage
     * @param start startingPage
     *
     * @return true if page order is right
     */
    public boolean pageOrderOk(String end, String start) {
        if (fieldNotEmpty(end) && fieldNotEmpty(start)) {
            if (endingPageBeforeStartingPage(end, start)) {
                return false;
            }
            return true;
        }
        return true;
    }

    /**
     * This method checks if input string is empty
     *
     * @param value String value of an input
     * @return true if value is not an empty String
     */
    public boolean fieldNotEmpty(String value) {
        return value.length() > 0;
    }

    /**
     * This method checks if with two string parameter converted to integers,
     * end is smaller than start
     *
     * @param end endingPage
     * @param start startingPage
     * @return true if startingPage is smaller than endingPage
     */
    public boolean endingPageBeforeStartingPage(String end, String start) {
        return Integer.parseInt(end) < Integer.parseInt(start);
    }

    /**
     * This method is for fixing authors for database (List) from an String
     *
     * @param authors List of authors
     * @return authors as a list
     */
    public List<String> fixAuthors(List<String> authors) {
        String authorString = authorsFromListToString(authors);
        return splitAuthors(authorString);
    }

    /**
     * This method is for creating author (String) from an ArrayList
     *
     * @param authors List of authors
     * @return authors as a String
     */
    public String authorsFromListToString(List<String> authors) {
        String authorString = "";
        for (int i = 0; i < authors.size() - 1; i++) {
            authorString = authorString + authors.get(i) + ", ";
        }
        authorString = authorString + authors.get(authors.size() - 1);
        return authorString;
    }

    /**
     * This method is for splitting authors (String) to an ArrayList
     *
     * @param authors all reference authors as a String
     * @return authors as a list
     */
    public List<String> splitAuthors(String authors) {
        List authorList = new ArrayList<>(Arrays.asList(authors.split(" and ")));
        return authorList;
    }

    /**
     * This method is for splitting tags (String) to an ArrayList
     *
     * @param tags String tags associated with a reference
     * @return List of tags
     */
    public List<String> splitTags(String tags) {
        List tagList = new ArrayList<>(Arrays.asList(tags.split(", ")));
        return tagList;
    }

    /**
     * This method generates a key for a reference if the user has not given a
     * key value
     *
     * @param ref Reference needing a key
     * @return Reference with a key
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

    /**
     * Method for adding a number for a key if there are two keys with same
     * initial values
     *
     * @param key String key that needs an additional number
     * @return String key
     */
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
