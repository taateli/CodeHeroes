package app.domain;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;


/**
 * This class is to create different proceedings objects.
 */
@Entity
@DiscriminatorValue(value = "Inproceedings")
public class Inproceedings extends Reference {

    /**
     * There are two possibilities of storing authors: String and
     * ArrayList<String>. It depends on the implementation, which of those will
     * remain.
     */
//    private List<String> authors;  
    private String author;
    private String title;
    private String bookTitle;
    private int year;
    private int startingPage;
    private int endingPage;
    private String publisher;
    private String address;

    /**
     * This constructor contains all the possible knowledge fields of a book.
     *
     * @param publisher is not compulsory.
     * @param address is not compulsory.
     * @return 
     */
//    public Inproceedings(List<String> authors, String author, String title, String booktitle, int year, int startingPage, int endingPage, String publisher, String address) {
////        this.authors = authors;
//        this.author = author;
//        this.title = title;
//        this.booktitle = booktitle;
//        this.year = year;
//        this.startingPage = startingPage;
//        this.endingPage = endingPage;
//        this.publisher = publisher;
//        this.address = address;
//    }
    
    @Override
    public String getTitle() {
        return this.title;
    }

    //    public List<String> getAuthors() {
//        return this.authors;
//    }
    /**
     * The method returns the authors, if they are saved as a String.
     * @return 
     */
    @Override
    public String getAuthor() {
        return this.author;
    }

    /**
     * The method returns the author at the position n on the list.
     * @return 
     */
//    public String getAuthor(int n) {
//        return this.authors.get(n);
//    }
    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public String getPublisher() {
        return this.publisher;
    }

    public int getStartingPage() {
        return this.startingPage;
    }

    public int getEndingPage() {
        return this.endingPage;
    }

    public String getAddress() {
        return this.address;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookTitle(String booktitle) {
        this.bookTitle = booktitle;
    }
    
    public String getBookTitle() {
        return this.bookTitle;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * The method inserts an author at the place n on the list. The possible
     * previous author at the place n is shifted to the rigth.
     * @param year
     */
    @Override
    public void setYear(int year) {
        this.year = year;
    }

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
        String tulostus = this.author + ". " + this.title + ". In " + this.bookTitle + ", pages " + this.startingPage + " - " + this.endingPage + ".";
        if (!this.publisher.isEmpty()) {
            tulostus = tulostus + " " + this.publisher + ",";
        }
        tulostus = " " + tulostus + this.year + ".";
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
