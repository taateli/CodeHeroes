package app.domain;


import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class is to create different book objects.
 */
@Entity
@DiscriminatorValue(value = "Book")
public class Book extends Reference {

    @NotEmpty(message = "Field can not be empty!")
    private String publisher;

    /**
     * Optional variables:
     */
    @Pattern(regexp = "^([1-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9]|[1-9][0-9][0-9][0-9][0-9])*$", message ="Field must contain number between 1 and 199999")
    private String vol;
    private String series;
    private String address;
    private String edition;
    
    @Pattern(regexp = "^([1-9]|[1][0-2])*$", message ="Field must contain number between 1 and 12")
    private String month;

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    
    
    public String getPublisher() {
        return this.publisher;
    }

    public String getAddress() {
        return this.address;
    }



   
    @Override
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method returns all the information of the book referenced. The
     * if-sentence allows the address field to be empty.
     *
     * @return The reference information of a book as a String.
     */
    @Override
    public String toString() {
        String tulostus = super.getAuthors() + ". " + super.getTitle() + ". " + this.publisher + ", " + super.getYear() + ".";
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
