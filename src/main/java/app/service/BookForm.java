/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author villepaa
 */
public class BookForm {
    
  
    // this field is common with all Reference types
    private String key;

    // this field is common with all Reference types
    @NotEmpty(message = "Field can not be empty!")
    private String title;

    // this field is common with all Reference types
    @Pattern(regexp = "^([1-9][0-9][0-9][0-9])*$", message = "Year must contain only numbers and be at least 1000!")
    @NotEmpty(message = "Field can not be empty!")
    private String year;

    // this field is common with all Reference types
    
    @NotEmpty(message = "Field can not be empty!")
    private String authors;
    
    @NotEmpty(message = "Field can not be empty!")
    private String publisher;

    /**
     * Optional variables:
     */
    private String address;
    
    private String edition;

    @Pattern(regexp = "^([1-9][0-9]{0,4})*$", message ="Field must contain number between 1 and 19999")
    private String volume;
     
    private String series;
    
    @Pattern(regexp = "^([1-9][0-2]{0,1})*$", message ="Field must contain number between 1 and 12")
    private String month;

    public String getVolume() {
        return volume;
    }

    public void setVolume(String vol) {
        this.volume = vol;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    
    
    
    public String getEdition() {
        return edition;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getAddress() {
        return this.address;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

  
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
