package app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * This class is the abstract class for the subclasses "Book", "Inproceedins"
 * and "Article".
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ReferenceType")
public abstract class Reference extends AbstractPersistable<Long> {

    @Id
    private Long id;

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
    @ElementCollection
    @CollectionTable(name = "authors")
    @NotEmpty(message = "Field can not be empty!")
    private List<String> authors;

    // this field is common with all Reference types
    @ElementCollection
    @CollectionTable(name = "tags")
    private List<String> tags;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

    public String authorsToBibTex() {
        return String.join(" and ", authors);
    }

    public String authorsToString() {
        int length = authors.size();

        if (length < 3) {
            return String.join(" and ", authors);
        } else {
            return String.join(", and ",
                    String.join(", ", authors.subList(0, length - 1)),
                    authors.get(length - 1));
        }
    }

    public String tagsToString() {
        String output = "";
        int length = this.tags.size();

        if (length == 1) {
            output = this.tags.get(0);
        } else if (length > 1) {
            output = String.join(",", tags);
        }

        return output;
    }

    @Override
    public abstract String toString();

    public abstract String toBibTex();
}
