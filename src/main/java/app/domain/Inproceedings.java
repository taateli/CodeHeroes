package app.domain;

import java.util.List;
import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@DiscriminatorValue(value = "Inproceedings")
public class Inproceedings extends Reference {

    @Id
    private Long id;

//    private List<String> authors;  //Mikäli kirjoittajalista on ArrayList-muodossa

    private String author;    //Mikäli kirjoittajalista on String-muodossa

    private String title;
    private String booktitle;
    private int year;
    private int startingPage;  //Laitetaan sivunumerot pakollisiksi, vaikka yhdessä BibTex-malliviitteessä
    private int endingPage;    //ei ollutkaan.
    private String publisher;
    private String address;

    //Laitan vain yhden konstruktorivaihtoehdon, koska mikäli joku kenttä jää tyhjäksi, sen voi alustaa "".
    //Kontruktorissa on kohtalaisen paljon muuttujia, mutta asialle ei voi mitään. Author-authors-valinta 
    //poistaa yhden muuttujan.

   
    public String getTitle() {
        return this.title;
    }


    public String getBookTitle() {
        return this.booktitle;
    }

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

    public void setBookTitle(String booktitle) {
        this.booktitle = booktitle;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    //Mikäli käytetään tekijöistä ArrayList-muotoa, tällä voi lisätä listaan kirjan n:nnen kirjoittajan.


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

    //Tällä on tarkoitus tulostaa koko viite String-muodossa.
    //Tässä oletan, että tekijät ovat listana valmiiksi String-muodossa.
    // Mikäli tekijät talletetaan ArrayList-muodossa, voi tehdä oman metodin,
    //jolla tekijät muutetaan String-muotoon.
    //Katsoin viitteen mallia tehtävänannosta.
    //Jossain viitteistä oli osoite, muttei kaikissa, sen tähden if-lause.
    //Elina on ekspertti viitteen oikean muodon suhteen...
    @Override
    public String toString() {
        String tulostus = this.author + ". " + this.title + ". In " + this.booktitle + ", pages " + this.startingPage + " - " + this.endingPage + ".";
        if (!this.publisher.isEmpty()) {
            tulostus = tulostus + " " + this.publisher + ",";
        }
        tulostus = " " + tulostus + this.year + ".";
        if (!this.address.isEmpty()) {
            tulostus = tulostus + " " + this.address + ".";
        }
        return tulostus;
    }

    @Override
    public String toBibTex() {
        return "";
    }


}
