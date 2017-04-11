package app.domain;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class is to create different proceedings objects.
 */
@Entity
@DiscriminatorValue(value = "Inproceedings")
public class Inproceedings extends Reference {


    /**
     * Compulsory variables:
     */
    @NotEmpty(message = "Field can not be empty!")
    private String bookTitle;

    /**
     * Optional variables:
     */

    private String editor;
    private Integer vol;
    private String series;
    private Integer startingPage;
    private Integer endingPage;
    private String address;
    private Integer month;
    private String organization;
    private String publisher;

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Integer getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
  

    



    @Override
    public String getPublisher() {
        return this.publisher;
    }

    public Integer getStartingPage() {
        return this.startingPage;
    }

    public Integer getEndingPage() {
        return this.endingPage;
    }

    public String getAddress() {
        return this.address;
    }



    public void setBookTitle(String booktitle) {
        this.bookTitle = booktitle;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

//    @Override
//    public void setAuthor(String author) {
//        this.author = author;
//    }

    /**
     * The method inserts an author at the place n on the list. The possible
     * previous author at the place n is shifted to the rigth.
     *
     * @param year
     */


    @Override
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStartingPage(int page) {
        this.startingPage = page;
    }

    public void setEndingPage(int page) {
        this.endingPage = page;
    }

    /**
     * This method returns all the information of the book referenced.
     *
     * The if -sentences allow the publisher- and address fields to be empty.
     *
     * @return The reference information of a book as a String.
     */
    @Override
    public String toString() {
        String tulostus = super.getAuthors() + ". " + super.getTitle() + ". In " + this.bookTitle + ", pages " + this.startingPage + " - " + this.endingPage + ".";
        if (!this.publisher.isEmpty()) {
            tulostus = tulostus + " " + this.publisher + ",";
        }
        tulostus = " " + tulostus + super.getYear() + ".";
        if (!this.address.isEmpty()) {
            tulostus = tulostus + " " + this.address + ".";
        }
        return tulostus;
    }

    /**
     * This method returns all the information of the book referenced as a
     * BibTex String.
     *
     * @return The BibTex-reference information of a book as a String.
     */
    @Override
    public String toBibTex() {
        return "Not supported yet";
    }

}
