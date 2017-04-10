
package app.domain;


import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * This class is the abstract class for the subclasses "Book", "Inproceedins" and "Article".
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ReferenceType")
public abstract class Reference extends AbstractPersistable<Long> {
    
    @Id
    private Long id;
    
    @NotEmpty(message = "Field can not be empty!")
    private String title;
    
    @Min(value = 1000, message = "Year must be at least 1000!")    
    private int year;
    
    @ElementCollection
    @CollectionTable(name="authors")
    private List<String> authors;

    public Long getId() {
        return id;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

        
    
    abstract String getPublisher();
      
    
    abstract void setPublisher(String publisher);
    
    @Override
    public abstract String toString();
    
    abstract String toBibTex();
}
