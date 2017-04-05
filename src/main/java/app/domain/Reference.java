
package app.domain;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
    
    private String type;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    
    
    
    abstract String getTitle(); 
//    abstract List<String> getAuthors();
    abstract String getAuthor();
    abstract int getYear();
    abstract String getPublisher();
    
    abstract void setTitle(String title);
    abstract void setAuthor(String author);
    abstract void setYear(int year);
    abstract void setPublisher(String publisher);
    
    @Override
    public abstract String toString();
    
    abstract String toBibTex();
}
