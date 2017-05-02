package app.domain;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
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
    private String publisher;

    @Pattern(regexp = "^([1-9][0-9]{0,4})*$", message = "Field must contain number between 1 and 19999")
    private String startingPage;

    @Pattern(regexp = "^([1-9][0-9]{0,4})*$", message = "Field must contain number between 1 and 199999")
    private String endingPage;

    private String address;

    @Pattern(regexp = "^([1-9][0-9]{0,4})*$", message = "Field must contain number between 1 and 19999")
    private String volume;
    private String series;
    @Pattern(regexp = "^([1-9][0-2]{0,1})*$", message = "Field must contain number between 1 and 12")
    private String month;
    private String organization;

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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getEditor() {
        return editor;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getStartingPage() {
        return this.startingPage;
    }

    public String getEndingPage() {
        return this.endingPage;
    }

    public String getAddress() {
        return this.address;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setBookTitle(String booktitle) {
        this.bookTitle = booktitle;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStartingPage(String page) {
        this.startingPage = page;
    }

    public void setEndingPage(String page) {
        this.endingPage = page;
    }

    public void setAddress(String address) {
        this.address = address;
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
        String output = super.authorsToString() + ". ";
        output = output + super.getTitle() + ". In ";
        if (!this.editor.isEmpty()) {
            output = output + this.editor + ", editor, ";
        }
        output = output + this.bookTitle;
        if (!this.volume.isEmpty()){
            output = output + ", volume " + this.volume;
        }
        if (!this.series.isEmpty()) {
            output = output + " (" + this.series + ")";
        }
        if (!this.startingPage.isEmpty() && !this.endingPage.isEmpty()) {
            output = output + ", pages " + this.startingPage + "-" + this.endingPage;
        }
        if (!this.publisher.isEmpty()) {
            output = output + ". " + this.publisher + ",";
        } else {
            output = output + ",";
        }
        if (!this.organization.isEmpty()) {
            output = output + " " + this.organization + ",";
        }
        if (!this.month.isEmpty()) {
            output = output + " " + this.month;
        }
        output = output + " " + super.getYear() + ".";
        if (!this.address.isEmpty()) {
            output = output + " " + this.address + ".";
        }
        output = output + " Key{" + super.getKey() + "}";
        if (!super.getTags().isEmpty()) {
            output = output + " " + super.tagsToString() + ".";
        }
        return output;
    }

    /**
     * This method returns all the information of the book referenced as a
     * BibTex String.
     *
     * @return The BibTex-reference information of a book as a String.
     */
    @Override
    public String toBibTex() {

        String output = "@inproceedings{" + super.getKey() + ",\n";
        output = output + "author = {" + super.authorsToBibTex() + "},\n";
        output = output + "title = {" + super.getTitle() + "},\n";
        output = output + "booktitle = {" + this.bookTitle + "},\n";
        output = output + "year = {" + super.getYear() + "},\n";
        if (!this.startingPage.isEmpty() && !this.endingPage.isEmpty()) {
            output = output + "pages = {" + this.startingPage + "--" + this.endingPage + "},\n";
        }
        if (!this.publisher.isEmpty()) {
            output = output + "publisher = {" + this.publisher + "},\n";
        }
        if (!this.address.isEmpty()) {
            output = output + "address = {" + this.address + "},\n";
        }
        if (!this.editor.isEmpty()) {
            output = output + "editor = {" + this.editor + "},\n";
        }
        if (!this.volume.isEmpty()) {
            output = output + "volume = {" + this.volume + "},\n";
        }
        if (!this.series.isEmpty()) {
            output = output + "series = {" + this.series + "},\n";
        }
        if (!this.month.isEmpty()) {
            output = output + "month = {" + this.month + "},\n";
        }
        if (!this.month.isEmpty()) {
            output = output + "organization = {" + this.organization + "},\n";
        }
        output = output + "}";
        return output;
    }

}
