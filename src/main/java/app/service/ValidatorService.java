/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author villepaa
 * This class is helper class for validating inputs and other helper methods
 */
@Service
public class ValidatorService {
    
 // This method checks if input string is empty   
    public boolean fieldNotEmpty(String value){
        return value.length() > 0;
    }

// This method checks if with two string parameter converted to int, end is smaller than start     
    public boolean endingPageBeforeStartingPage(String end, String start){
        return Integer.parseInt(end) < Integer.parseInt(start);
    }

// This methid is for splitting authors string to arraylist    
    public List<String> splitAuthors(String authors){
        List authorList = new ArrayList<>(Arrays.asList(authors.split(" and ")));
        return authorList;
    }
}
