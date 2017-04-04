package app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue(value = "Book")
public class Book extends Reference  {

    @Id
    private Long id;


//    private List<String> authors;  //Mikäli kirjoittajalista on ArrayList-muodossa
    private String author;    //Mikäli kirjoittajalista on String-muodossa
    private String title;
    private int year;
    private String publisher;
    private String address;

    //Tässä kontruktorissa on kaikki mahdolliset kentät. Osoite-kenttä ei ollut pakollinen,
    //mutta se löytyi yhdestä viitteestä.
   

//    //Tämä konstruktori on sitä varten, että useimmiten malliviitteissä ei ollut osoitetta.
//    //Tässä asetetaan vain pakolliset kentät.
//    public Book(String author, ArrayList<String> authors, String title, int year, String publisher) {
//        //Joko:
////        this.authors = authors;
//        //Tai:
//        this.author = author;
//        this.title = title;
//        this.year = year;
//        this.publisher = publisher;
//        this.address = "";
//    }

    @Override
    public String getTitle() {
        return this.title;
    }

    //Mikäli halutaan palauttaa koko kirjoittajalista:
  

    //Tällä palautetaan n:s kirjoittaja.
//    public String getAuthor(int n) {
//        return this.authors.get(n);
//    }

    //Mikäli käytetään String-muotoista versiota, jossa kirjoittajat
    //ovat jo valmiiksi toString()-muodossa.
    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    // @Override
    public String getPublisher() {
        return this.publisher;
    }

    public String getAddress() {
        return this.address;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    //Mikäli käytetään tekijöistä ArrayList-muotoa, tällä voi lisätä listaan kirjan n:nnen kirjoittajan.
//    public void setAuthor(String author, int n) {
//        this.authors.add(n, title);
//    }

    //Tällä voi asettaa kaikki kirjoittajat, mikäli ne on String-muodossa.
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

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

    //Tällä on tarkoitus tulostaa koko viite String-muodossa.
    //Tässä oletan, että tekijät ovat listana valmiiksi String-muodossa.
    // Mikäli tekijät talletetaan ArrayList-muodossa, voi tehdä oman metodin,
    //jolla tekijät muutetaan String-muotoon.
    //Katsoin viitteen mallia tehtävänannosta.
    //Jossain viitteistä oli osoite, muttei kaikissa, sen tähden if-lause.
    //Elina on ekspertti viitteen oikean muodon suhteen...
    @Override
    public String toString() {
        String tulostus = this.author + ". " + this.title + ". " + this.publisher + ", " + this.year + ".";
        if (!this.address.isEmpty()) {
            tulostus = tulostus + " " + this.address + ".";
        }
        return tulostus;
    }

    //Tällä on tarkoitus tulostaa koko viite BibTex-muodossa.
    @Override
    public String toBibTex() {
        return "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
