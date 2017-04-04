package app.domain;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Inproceedings")
public class Inproceedings extends Reference {
    
    
//    private List<String> authors;  //Mikäli kirjoittajalista on ArrayList-muodossa
    private String author;    //Mikäli kirjoittajalista on String-muodossa

    private String title;
    private String booktitle;
    private int year;
    private int startingPage;
    private int endingPage;
    private String publisher;
    private String address;

    //Laitan vain yhden konstruktorivaihtoehdon, koska mikäli joku kenttä jää tyhjäksi, sen voi alustaa "".
    //Kontruktorissa on kohtalaisen paljon muuttujia, mutta asialle ei voi mitään. Author-authors-valinta 
    //poistaa yhden muuttujan.
    
    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        return this.title;
    }

//    @Override
//    public List<String> getAuthors() {
//        return this.authors;
//    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    //Tällä palautetaan n:s kirjoittaja.
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

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
    
    //Mikäli käytetään tekijöistä ArrayList-muotoa, tällä voi lisätä listaan kirjan n:nnen kirjoittajan.
   
//    public void setAuthor(String author, int n) {
//        this.authors.add(n, title);
//    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAddress(String address){
        this.address = address;
    }
    
    public void setStartingPage(int page) {
        this.startingPage = page;
    }
    
    public void setEndingPage(int page) {
        this.endingPage = page;
    }
    //Tämä puuttuu vielä, koska ei olla päätetty, missä muodossa kirjoittajat ovat.
    @Override
    public String toString() {
        return "";
    }
    
    @Override
    public String toBibTex() {
        return "";
    }

   

}
